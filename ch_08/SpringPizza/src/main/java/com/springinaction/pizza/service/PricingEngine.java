package com.springinaction.pizza.service;

import com.springinaction.pizza.domain.Order;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-25 15:24
 * Description:
 */
public interface PricingEngine {
    public float calculateOrderTotal(Order order);
}
