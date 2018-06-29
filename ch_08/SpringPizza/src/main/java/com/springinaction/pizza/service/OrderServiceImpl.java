package com.springinaction.pizza.service;

import com.springinaction.pizza.domain.Order;
import org.apache.log4j.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-25 15:18
 * Description:
 */
public class OrderServiceImpl {
    private static final Logger LOGGER = Logger.getLogger(OrderServiceImpl.class);

    public OrderServiceImpl() {

    }

    public void saveOrder(Order order) {
        LOGGER.debug("SAVING ORDER:  ");
        LOGGER.debug("   Customer:  " + order.getCustomer().getName());
        LOGGER.debug("   # of Pizzas:  " + order.getPizzas().size());
        LOGGER.debug("   Payment:  " + order.getPizzas());
    }
}
