package com.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-31 20:29
 * Description:
 */
@Configuration
public class EnvironmentConfigWithRequiredProperties {

    @Autowired
    Environment env;

    @Bean
    public BlankDisc blankDisc() {
        return new BlankDisc(
                env.getRequiredProperty("disc.title"),
                env.getRequiredProperty("disc.artist"));
    }
}
