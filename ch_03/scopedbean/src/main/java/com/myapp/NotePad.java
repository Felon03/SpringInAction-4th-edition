package com.myapp;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-31 19:27
 * Description: bean scope with prototype
 */

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class NotePad {

}
