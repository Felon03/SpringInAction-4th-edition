package com.springinaction.pizza.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-25 9:55
 * Description: Payment class
 */
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    private float amount;

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getAmount() {
        return amount;
    }
}
