package soundsystem;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-30 14:09
 * Description: 带有@Component注解的CompactDisc实现类SgtPeppers
 */

// Spring会默认给上下文中的所有bean给定一个默认ID(将类名的首字母改为小写)，
// 我们也可以为bean设置自定义的ID，只需将期望的ID作为值传递给@Component注解
// 如@Component("sgtPeppers")
@Component  // 表明该类会作为组建类，并告知Spring要为这个类创建bean
public class SgtPeppers implements CompactDisc {

    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
