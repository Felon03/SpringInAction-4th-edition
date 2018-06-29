package sia.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sia.knights.config.KnightConfig;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-29 15:29
 * Description:
 */
public class KnightMain {

    public static void main(String[] args) {
        // 加载Spring上下文(XML)
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/spring/knights.xml");
        // 获取knight bean
        Knight knight = context.getBean(Knight.class);
        // 使用knight
        knight.embarkOnQuest();
//        context.close();

        // 获取通过java配置的上下文
        AnnotationConfigApplicationContext context1 =
                new AnnotationConfigApplicationContext(KnightConfig.class);
        knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
        context1.close();
    }
}
