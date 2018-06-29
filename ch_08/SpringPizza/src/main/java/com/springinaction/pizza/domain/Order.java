package com.springinaction.pizza.domain;

import com.springinaction.pizza.service.PricingEngine;
import com.springinaction.pizza.service.PricingEngineImpl;
import org.springframework.beans.factory.annotation.Configurable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-25 9:44
 * Description: pizza order class
 */

@Configurable("order")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    private Customer customer;
    private List<Pizza> pizzas;
    private Payment payment;
    private PricingEngine pricingEngine;

    public Order() {
        pizzas = new ArrayList<>();
        customer = new Customer();
        pricingEngine = new PricingEngineImpl();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public float getTotal() {
//        return 0.0f;
        return pricingEngine.calculateOrderTotal(this);
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public PricingEngine getPricingEngine() {
        return pricingEngine;
    }

    public void setPricingEngine(PricingEngine pricingEngine) {
        this.pricingEngine = pricingEngine;
    }
}
