package spittr.db;

import spittr.domain.Spittle;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-27 10:28
 * Description: Repository interface with operations for {@link spittr.domain.Spittle} persistence
 */
public interface SpittleRepository {

    long count();

    List<Spittle> findRecent();

    List<Spittle> findRecent(int count);

    Spittle findOne(long id);

    Spittle save(Spittle spittle);

    List<Spittle> findBySpitterId(long spitterID);

    void delete(long id);
}
