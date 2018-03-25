package com.eMusicShopping.controller;

import com.eMusicShopping.model.BillingAddress;
import com.eMusicShopping.model.Customer;
import com.eMusicShopping.model.ShippingAddress;
import com.eMusicShopping.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    ICustomerService customerService;

    @RequestMapping("/register")
    public String register(Model model) {

        Customer customer = new Customer();
        BillingAddress billing = new BillingAddress();
        ShippingAddress shipping = new ShippingAddress();

        customer.setBillingAddress(billing);
        customer.setShippingAddress(shipping);

        model.addAttribute("customer", customer);

        return "registerCustomer";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(@Valid @ModelAttribute("customer") Customer customer, BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            return "registerCustomer";
        }

        String hash = null;
        System.out.println("pin "+customer.getPin_alg());
        if (customer.getPin_alg().equals("1"))
            hash = customerService.getMD5(customer.getPin());
        if (customer.getPin_alg().equals("2"))
            hash = customerService.SHA256(customer.getPin());
        if (customer.getPin_alg().equals("3"))
            hash = customerService.PBKDF2WithHmacSHA1(customer.getPin(),"salt");

        customer.setPin(hash);

        customer.setEnabled(true);
        customerService.addCustomer(customer);
        return "registerCustomerSuccess";
    }
}
