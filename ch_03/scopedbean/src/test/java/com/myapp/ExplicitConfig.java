package com.myapp;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-31 19:37
 * Description:
 */

@Component
public class ExplicitConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public NotePad notePad() {
        return new NotePad();
    }

    @Bean
    public UniqueThing uniqueThing() {
        return new UniqueThing();
    }
}
