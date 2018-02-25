package com.eMusicShopping.service;

import com.eMusicShopping.model.CustomerOrder;

/**
 * Created by dario on 10/11/2016.
 */
public interface ICustomerOrderService {

    void addCustomerOrder(CustomerOrder customerOrder);

    double getCustomerOrderGrandTotal(int cartId);

}
