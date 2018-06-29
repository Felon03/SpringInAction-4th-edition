package com.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-31 20:24
 * Description:
 */

@Configuration
@PropertySource("classpath:/com/soundsystem/app.properties")    // 声明属性源
public class EnvironmentConfig {

    @Autowired
    Environment env;

    @Bean BlankDisc blankDisc() {
        return new BlankDisc(
                env.getProperty("disc.title"),
                env.getProperty("disc.artist"));
    }

}
