package spittr.data;

import spittr.Spitter;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-13 20:25
 * Description:
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUserName(String username);
}
