package com.eMusicShopping.controller;

import com.eMusicShopping.model.Customer;
import com.eMusicShopping.model.Product;
import com.eMusicShopping.service.ICustomerService;
import com.eMusicShopping.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ICustomerService customerService;

    private Path path;

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        model.addAttribute("productClass","active");
        return "productInventory";
    }

    @RequestMapping(value ="/admin/productInventory/addProduct", method = RequestMethod.GET)
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("productClass","active");
        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,
                             HttpServletRequest httpServletRequest,Model model) {

        if (bindingResult.hasErrors()) {
            return "addProduct";
        }
        productService.addProduct(product);

        model.addAttribute("productClass","active");
        MultipartFile productImage = product.getProductImage();
        String rootPath = httpServletRequest.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootPath + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        saveImageAsProductId(productImage);

        return "redirect:/admin/productInventory";
    }

    private void saveImageAsProductId(MultipartFile productImage) {
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException("Product Image saving Failed");
            }
        }
    }

    @RequestMapping("/admin/productInventory/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable int productId, Model model, HttpServletRequest request) {

        model.addAttribute("productClass","active");
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "//WEB-INF//resources//images//" + productId + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        productService.deleteProduct(productId);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/editProduct/{productId}")
    public String editProduct(@PathVariable int productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute(product);

        model.addAttribute("productClass","active");
        return "editProduct";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult
            , HttpServletRequest httpServletRequest,Model model) {

        if (bindingResult.hasErrors()) {
            return "editProduct";
        }
        MultipartFile productImage = product.getProductImage();
        String rootPath = httpServletRequest.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootPath + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        model.addAttribute("productClass","active");
        saveImageAsProductId(productImage);

        productService.editProduct(product);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping(value = "/admin/customer",method = RequestMethod.GET)
    public String customerManagement(Model model){
        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList",customerList);
        return "customerManagement";
    }
}
