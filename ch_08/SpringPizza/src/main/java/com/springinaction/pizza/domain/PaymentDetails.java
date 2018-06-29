package com.springinaction.pizza.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-25 14:22
 * Description: Order payment detail
 */
public class PaymentDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    private PaymentType paymentType;
    private String creditCardNumber;

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
