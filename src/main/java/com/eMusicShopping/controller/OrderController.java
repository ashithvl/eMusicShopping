package com.eMusicShopping.controller;

import com.eMusicShopping.model.Cart;
import com.eMusicShopping.model.Customer;
import com.eMusicShopping.model.CustomerOrder;
import com.eMusicShopping.service.ICartService;
import com.eMusicShopping.service.ICustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dario on 10/11/2016.
 */
@Controller
public class OrderController {

    @Autowired
    private ICartService ICartService;

    @Autowired
    private ICustomerOrderService ICustomerOrderService;

    @RequestMapping("/order/{cart_id}")
    public String createOrder(@PathVariable("cart_id") int cart_id){
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = ICartService.getCartById(cart_id);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customerOrder.setBillingAddress(customer.getBillingAddress());
        customer.setShippingAddress(customer.getShippingAddress());

        ICustomerOrderService.addCustomerOrder(customerOrder);

        return "redirect:/checkout?id="+cart_id;
    }

}
