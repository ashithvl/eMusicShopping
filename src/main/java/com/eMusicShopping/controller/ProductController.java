package com.eMusicShopping.controller;

import com.eMusicShopping.model.Product;
import com.eMusicShopping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/productList")
    public String getProducts(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        model.addAttribute("productClass","active");
        return "productList";
    }

    @RequestMapping("/productList/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute(product);
        model.addAttribute("productClass","active");
        return "viewProduct";
    }


}
