package com.springinaction.pizza.service;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-25 15:02
 * Description:
 */
public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException() {

    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
