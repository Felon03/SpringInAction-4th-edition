package spittr.db;

import spittr.domain.Spitter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-27 10:26
 * Description: Repository interface with operation for {@link spittr.domain.Spitter} persistence
 */
public interface SpitterRepository {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUserName(String username);

    List<Spitter> findAll();
}
