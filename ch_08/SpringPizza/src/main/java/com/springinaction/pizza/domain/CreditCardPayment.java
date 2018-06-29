package com.springinaction.pizza.domain;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-25 14:50
 * Description: Credit card payment
 */
public class CreditCardPayment extends Payment {
    public CreditCardPayment() {

    }

    private String authorization;

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    @Override
    public String toString() {
        return "CREDIT: $" + getAmount() + " ;AUTH: " + authorization;
    }
}
