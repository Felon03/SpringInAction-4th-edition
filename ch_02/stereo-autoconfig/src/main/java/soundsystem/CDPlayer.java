package soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-30 14:44
 * Description: 通过自动装配， 将一个CompactDisc注入到CDPlayer之中
 */

@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Autowired  // @Autowired注解不仅能够用在构造器上，还能用在属性的Setter方法上
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
