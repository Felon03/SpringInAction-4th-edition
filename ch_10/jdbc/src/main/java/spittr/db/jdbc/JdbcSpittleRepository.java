package spittr.db.jdbc;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import spittr.db.SpittleRepository;
import spittr.domain.Spitter;
import spittr.domain.Spittle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-27 10:48
 * Description:
 */
public class JdbcSpittleRepository implements SpittleRepository {

    private static final String SELECT_SPITTLE =
            "select sp.id, s.id as spitterId, s.username, s.password, s.fullName, s.email, s.updateByEmail, " +
                    "sp.message, sp.postedTime from spittle sp, spitter s where sp.spitter = s.id";
    private static final String SELECT_SPITTLE_BY_ID = SELECT_SPITTLE + " and sp.id=?";
    private static final String SELECT_SPITTER_BY_SPITTER_ID = SELECT_SPITTLE + " and s.id=? order by sp.postedTime desc";
    private static final String SELECT_RECENT_SPITTLES = SELECT_SPITTLE + " order by sp.postedTime desc limit ?";

    private JdbcTemplate jdbcTemplate;

    public JdbcSpittleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @SuppressWarnings("deprecated")
    public long count() {
        return jdbcTemplate.queryForLong("select count(id) from spittle");
    }

    @Override
    public List<Spittle> findRecent() {
        return findRecent(10);
    }

    @Override
    public List<Spittle> findRecent(int count) {
//        return jdbcTemplate.query(SELECT_RECENT_SPITTLES, new SpittleRowMapper(), count);
        return jdbcTemplate.query(SELECT_RECENT_SPITTLES, this::mapSpittle, count);
    }

    @Override
    public Spittle findOne(long id) {
        try {
//            return jdbcTemplate.queryForObject(SELECT_SPITTLE_BY_ID, new SpittleRowMapper(), id);
            return jdbcTemplate.queryForObject(SELECT_SPITTLE_BY_ID, this::mapSpittle, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Spittle save(Spittle spittle) {
        long spittleId = insertSpittleAndReturnId(spittle);
        return new Spittle(spittleId, spittle.getSpitter(), spittle.getMessage(), spittle.getPostedTime());
    }

    /**
     * Insert a spittle using SimpleJdbcInsert
     * Involves no direct SQL and is able to return the ID of the newly created Spittle
     * @param spittle a Spittle to insert into the database
     * @return the ID of the newly created Spittle
     */
    private long insertSpittleAndReturnId(Spittle spittle) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("spittle");
        jdbcInsert.setGeneratedKeyName("id");
        Map<String, Object> args = new HashMap<>();
        args.put("spitter", spittle.getSpitter().getId());
        args.put("message", spittle.getMessage());
        args.put("postedTime", spittle.getPostedTime());
        long spittleId = jdbcInsert.executeAndReturnKey(args).longValue();
        return spittleId;
    }

    @Override
    public List<Spittle> findBySpitterId(long spitterID) {
//        return jdbcTemplate.query(SELECT_SPITTER_BY_SPITTER_ID, new SpittleRowMapper(), spitterID);
        return jdbcTemplate.query(SELECT_SPITTER_BY_SPITTER_ID, this::mapSpittle, spitterID);
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("delete from spittle where id=?", id);
    }

    private Spittle mapSpittle(ResultSet rs, int row) throws SQLException {
        Spitter spitter = new Spitter(
                rs.getLong("spitterId"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("fullName"),
                rs.getString("email"),
                rs.getBoolean("updateByEmail")
        );
        return new Spittle(
                rs.getLong("id"),
                spitter,
                rs.getString("message"),
                rs.getTimestamp("postedTime")
        );
    }

    private static final class SpittleRowMapper implements RowMapper<Spittle> {

        @Override
        public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String message = rs.getString("message");
            Date postedTime = rs.getTimestamp("postedTime");
            long spitterId = rs.getLong("spitterId");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String fullName = rs.getString("fullName");
            String email = rs.getString("email");
            boolean updateByEmail = rs.getBoolean("updateByEmail");
            Spitter spitter = new Spitter(spitterId, username, password, fullName, email, updateByEmail);
            return new Spittle(id, spitter, message, postedTime);
        }
    }
}
