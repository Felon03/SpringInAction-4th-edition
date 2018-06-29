package soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-30 14:13
 * Description: @ComponentScan注解启用了组建扫描
 */


// @ComponentScan注解能够在Spring中启用组件扫描
// 如果没有其他配置的话， @ComponentScan默认会扫描与配置类相同的包
// 可以通过在@ComponentScan的value属性中指定报的名称来实现扫描不同的包
// 如@ComponentScan("soundsystem")
// 如果想要更加清晰地表明所设置的是基础包，可以通过basePackages属性进行配置
// @ComponentScan(basePackages="soundsystem")
// 也可以设置多个基础包，只需将basePackages属性设置为要扫描包的一个数组即可
// @ComponentScan(basePackages={"soundsystem", "video})
// 除了将包设置为简单的String类之外，还可以将其指定为包中所包含的类或接口
// @ComponentScan(basePackageClasses={CDPlayer.class, DVDPlayer.class})
@Configuration
@ComponentScan
public class CDPlayerConfig {
}
