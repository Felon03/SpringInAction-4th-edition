package com.springinaction.pizza.service;

import com.springinaction.pizza.PaymentException;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-25 15:21
 * Description:
 */
public class PaymentProcessor {
    public PaymentProcessor() {

    }

    public void approvedCreditCard(String creditCardNumber, String expMonth,
                                   String expYear, float amount) throws PaymentException {
        if (amount > 20.00) {
            throw new PaymentException();
        }
    }
}
