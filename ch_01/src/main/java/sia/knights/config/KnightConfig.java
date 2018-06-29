package sia.knights.config;

import org.springframework.context.annotation.Bean;
import sia.knights.BraveKnight;
import sia.knights.Knight;
import sia.knights.Quest;
import sia.knights.SlayDragonQuest;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-29 15:28
 * Description:
 */
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}
