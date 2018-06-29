package spittr.db.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import spittr.db.SpitterRepository;
import spittr.domain.Spitter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-27 10:46
 * Description:
 */
public class JdbcSpitterRepository implements SpitterRepository {

    private static final String SELECT_SPITTER =
            "select id, username, password, fullName, email, updateByEmail from spitter";
    private static final String INSERT_SPITTER =
            "insert into spitter (username, password, fullName, email, updateByEmail) values (?, ?, ?, ?, ?)";

    private JdbcTemplate jdbcTemplate;

    public JdbcSpitterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @SuppressWarnings("deprecated")
    public long count() {
        return jdbcTemplate.queryForLong("select count(id) from spitter");
    }

    @Override
    public Spitter save(Spitter spitter) {
        Long id = spitter.getId();
        if (id == null) {
            long spitterId = insertSpitterAndReturnId(spitter);
            return new Spitter(spitterId, spitter.getUsername(), spitter.getPassword(),
                    spitter.getFullName(), spitter.getEmail(), spitter.isUpdateByEmail());
        } else {
            jdbcTemplate.update("update spitter set username=?, " +
                    "password=?, fullName=?, email=?, updateByEmail=? where id=?",
                    spitter.getUsername(),
                    spitter.getPassword(),
                    spitter.getFullName(),
                    spitter.getEmail(),
                    spitter.isUpdateByEmail(),
                    id);
        }
        return spitter;
    }

    /**
     * Inserts a spitter using SimpleJdbcInsert
     * Involves no direct SQL and is able to return the ID of the newly created Spitter
     * @param spitter a Spitter to insert into the database
     * @return the ID of the newly created Spitter
     */
    private long insertSpitterAndReturnId(Spitter spitter) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("spitter");
        jdbcInsert.setGeneratedKeyName("id");
        Map<String, Object> args = new HashMap<>();
        args.put("username", spitter.getUsername());
        args.put("password", spitter.getPassword());
        args.put("fullName", spitter.getFullName());
        args.put("email", spitter.getEmail());
        args.put("updateByEmail", spitter.isUpdateByEmail());
        long spitterId = jdbcInsert.executeAndReturnKey(args).longValue();
        return spitterId;
    }

    /**
     * Insert a spitter using a simple JdbcTemplate update() call
     * Does not return the ID of the newly created Spitter
     * @param spitter a Spitter to insert into the database
     */
    private void insertSpitter(Spitter spitter) {
        jdbcTemplate.update(INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
    }

    @Override
    public Spitter findOne(long id) {
//        return jdbcTemplate.queryForObject(
//                SELECT_SPITTER + "where id=?", new SpitterRowMapper(), id);
        return jdbcTemplate.queryForObject(
                SELECT_SPITTER + " where id=?", this::mapSpitter, id);
    }


    @Override
    public Spitter findByUserName(String username) {
//        return jdbcTemplate.queryForObject(
//                "select id, username, password, fullName, email, updateByEmial from spitter where username=?",
//                new SpitterRowMapper(), username);
        return jdbcTemplate.queryForObject(
                "select id, username, password, fullName, email, updateByEmail from spitter where username=?",
                this::mapSpitter, username);
    }

    @Override
    public List<Spitter> findAll() {
//        return jdbcTemplate.query(
//                "select id, username, password, fullName, email, updateByEmail form spitter order by id",
//                new SpitterRowMapper());
        return jdbcTemplate.query(
                "select id, username, password, fullName, email, updateByEmail from spitter order by id",
                this::mapSpitter);
    }

    // 可以使用java8的方法引用，在单独的方法映射引用
    private Spitter mapSpitter(ResultSet rs, int row) throws SQLException {
        return new Spitter(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("fullName"),
                rs.getString("email"),
                rs.getBoolean("updateByEmail")
        );
    }

    private static final class SpitterRowMapper implements RowMapper<Spitter> {

        @Override
        public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String username = rs.getString("username");
            String password = rs.getString("password");
            String fullName = rs.getString("fullName");
            String email = rs.getString("email");
            boolean updateByEmail = rs.getBoolean("updateByEmail");
            return new Spitter(id, username, password, fullName, email, updateByEmail);
        }
    }
}
