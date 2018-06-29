package com.springinaction.pizza.service;

import com.springinaction.pizza.domain.Customer;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-25 15:03
 * Description:
 */
public interface CustomerService {
    Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException;
}
