package com.habuma.restfun;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-31 16:34
 * Description: 条件化地配置bean
 */
public class MagicConfig {

    @Bean
    @Conditional(MagicExistCondition.class)
    public MagicBean magicBean() {
        return new MagicBean();
    }
}
