package com.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-31 20:27
 * Description:
 */
@Configuration
public class EnvironmentConfigWithDefaults {

    @Autowired
    Environment env;

    @Bean
    public BlankDisc blankDisc() {
        return new BlankDisc(
                env.getProperty("disc.title", "Rattle and Hum"),
                env.getProperty("disc.artist", "U2"));
    }
}
