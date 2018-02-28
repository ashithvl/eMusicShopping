package com.eMusicShopping.controller;

import com.eMusicShopping.model.Customer;
import com.eMusicShopping.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {


    @Autowired
    private ICustomerService customerService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("home", "active");
        return "home";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout, Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid username and password");
        }

        if (logout != null) {
            model.addAttribute("msg", "You have been Successfully logged Out");
        }

        return "login";
    }

    @RequestMapping("/loginPin")
    public String login(@RequestParam(value = "error", required = false) String error, Model model,
                        HttpServletRequest request) {

        String pin = request.getParameter("pin");
        String pinOption = request.getParameter("alg");

        if (pin != null && pinOption != null) {
            Customer customer = customerService.checkPin(pin, pinOption);
            if (customer != null)
                return "redirect:/product/productList";
            else {
                model.addAttribute("error", "Invalid Pin or Algorithm");
                return "pinLogin";
            }
        }else {
            model.addAttribute("error", "Please enter you four digit Pin and Algorithm");
            return "pinLogin";
        }
    }
}
