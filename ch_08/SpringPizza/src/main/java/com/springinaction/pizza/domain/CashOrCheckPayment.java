package com.springinaction.pizza.domain;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-25 14:49
 * Description: Cash and check payment
 */
public class CashOrCheckPayment extends Payment {

    public CashOrCheckPayment() {

    }

    @Override
    public String toString() {
        return "CASH or CHECK: $" + getAmount();
    }
}
