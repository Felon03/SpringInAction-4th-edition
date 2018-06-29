package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-30 15:17
 * Description: 通过JavaConfig显式配置Spring
 */

// @Configuration注解表明这个类是一个配置类， 该类应该包含在Spring应用上下文中如何创建bean的细节
@Configuration
public class CDPlayerConfig {

    @Bean
    public CompactDisc compactDisc() {
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }
}
