package com.springinaction.pizza.domain;

import org.apache.commons.lang3.text.WordUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-25 14:19
 * Description: Order payment type
 */
public enum PaymentType {
    CASH, CHECK, CREDIT_CARD;

    public static List<PaymentType> asList() {
        PaymentType[] all = PaymentType.values();
        return Arrays.asList(all);
    }

    @Override
    public String toString() {
        return WordUtils.capitalizeFully(name().replace('_', ' '));
    }
}
