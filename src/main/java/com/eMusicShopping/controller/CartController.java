package com.eMusicShopping.controller;

import com.eMusicShopping.model.Customer;
import com.eMusicShopping.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by dario on 08/11/2016.
 */
@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping
    public String getCart(Principal principal) {
        Customer customer = customerService.getCustomerByUsername(principal.getName());
        int cart_id = customer.getCart().getCart_id();

        return "redirect:/customer/cart/" + cart_id;
    }

    @RequestMapping("/{cart_id}")
    public String getCartRedirect(@PathVariable(value = "cart_id")int cart_id, Model model) {
        model.addAttribute(cart_id);

        return "cart";
    }

}
