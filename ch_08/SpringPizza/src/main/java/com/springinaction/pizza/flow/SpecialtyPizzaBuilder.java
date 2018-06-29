package com.springinaction.pizza.flow;

import com.springinaction.pizza.domain.Pizza;
import com.springinaction.pizza.domain.Topping;
import org.apache.log4j.Logger;
import org.springframework.webflow.execution.Action;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-25 15:10
 * Description:
 */
public class SpecialtyPizzaBuilder implements Action {

    private static final Logger LOGGER = Logger.getLogger(SpecialtyPizzaBuilder.class);

    public Event execute(RequestContext request) throws Exception {
        String type = request.getRequestParameters().get("pizzaType");

        LOGGER.debug("BUILDING A SPECIALTY PIZZA: " + type);

        Pizza pizza = (Pizza) request.getFlowScope().get("pizza");
        if ("MEAT".equals(type)) {
            LOGGER.debug("BUILDING A CARNIVORE");

            List<Topping> meats = new ArrayList<>();

            meats.add(Topping.CANADIAN_BACON);
            meats.add(Topping.HAMBURGER);
            meats.add(Topping.PEPPERONI);
            meats.add(Topping.SAUASGE);

            pizza.setToppings(meats);
        } else if ("THEWORKS".equals(type)) {
            LOGGER.debug("BUILDING AN OMNIVORE");

            List<Topping> meats = new ArrayList<>();
            System.out.println("THE WORKS");

            meats.add(Topping.CANADIAN_BACON);
            meats.add(Topping.HAMBURGER);
            meats.add(Topping.PEPPERONI);
            meats.add(Topping.SAUASGE);
            meats.add(Topping.GREEN_PEPPER);
            meats.add(Topping.MUSHROOM);
            meats.add(Topping.PINEAPPLE);
            meats.add(Topping.TOMATO);
            meats.add(Topping.EXTRA_CHEESE);
            meats.add(Topping.ONION);
            meats.add(Topping.JALAPENO);

            pizza.setToppings(meats);
        }
        request.getFlowScope().put("pizza", pizza);

        return new Event(this, "success");
    }
}
