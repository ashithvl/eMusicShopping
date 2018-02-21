package com.eMusicShopping.controller;

import com.eMusicShopping.model.Product;
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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private IProductService productService;

    private Path path;

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);

        return "productInventory";
    }

    @RequestMapping("/admin/productInventory/addProduct")
    public String addProduct(Model model) {
        Product product = new Product();

        model.addAttribute("product", product);

        return "addProduct";
    }

    @RequestMapping(value = "/admin/productInventory/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,
                             HttpServletRequest httpServletRequest) {

        if (bindingResult.hasErrors()) {
            return "addProduct";
        }
        productService.addProduct(product);

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
    public String deleteProduct(@PathVariable int productId, Model model) {
        productService.deleteProduct(productId);

        return "redirect:/admin/productInventory";
    }

    @RequestMapping("/admin/productInventory/editProduct/{productId}")
    public String editProduct(@PathVariable int productId, Model model) {
        Product product = productService.getProductById(productId);
        model.addAttribute(product);

        return "editProduct";
    }

    @RequestMapping(value = "/admin/productInventory/editProduct", method = RequestMethod.POST)
    public String editProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult
            , HttpServletRequest httpServletRequest) {

        if (bindingResult.hasErrors()) {
            return "editProduct";
        }
        MultipartFile productImage = product.getProductImage();
        String rootPath = httpServletRequest.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootPath + "\\WEB-INF\\resources\\images\\" + product.getProductId() + ".png");

        saveImageAsProductId(productImage);

        productService.editProduct(product);

        return "redirect:/admin/productInventory";
    }
}
