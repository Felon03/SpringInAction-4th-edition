package spittr.db;

import spittr.domain.Spitter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-29 9:58
 * Description: Repository interface with operations for {@link spittr.domain.Spitter} persistence
 */
public interface SpitterRepository {

    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}
