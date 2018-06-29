package sia.knights;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-30 9:26
 * Description:
 */
@Component
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(stream());
    }

    @Bean
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public PrintStream stream() {
        return new FakePrintStream();
    }
}
