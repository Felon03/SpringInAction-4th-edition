package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-31 10:42
 * Description:
 */
@Configuration
public class CDConfig {

    @Bean
    public CompactDisc compactDisc() {
        return new SgtPeppers();
    }
}
