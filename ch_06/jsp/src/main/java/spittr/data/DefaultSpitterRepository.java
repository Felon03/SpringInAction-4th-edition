package spittr.data;

import org.springframework.context.annotation.Configuration;
import spittr.Spitter;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-13 20:33
 * Description:
 */

@Configuration
public class DefaultSpitterRepository implements SpitterRepository {
    @Override
    public Spitter save(Spitter spitter) {
        return spitter;
    }

    @Override
    public Spitter findByUserName(String username) {
        return createSpitter(username);
    }

    private Spitter createSpitter(String username) {
        return new Spitter(username, "199310033",
                "Tom", "Felix", "freedom.jfl@live.com");
    }
}
