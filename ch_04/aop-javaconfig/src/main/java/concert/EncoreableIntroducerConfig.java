package concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-06 16:27
 * Description:
 */
@Configuration
public class EncoreableIntroducerConfig {

    @Bean
    EncoreableIntroducer encoreableIntroducer() {
        return new EncoreableIntroducer();
    }
}
