package com.eMusicShopping.controller;

import com.eMusicShopping.model.Cart;
import com.eMusicShopping.model.CartItem;
import com.eMusicShopping.model.Customer;
import com.eMusicShopping.model.Product;
import com.eMusicShopping.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.List;

/**
 * Created by dario on 08/11/2016.
 */
@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICartItemService cartItemService;

    @Autowired
    private ICartService cartService;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICustomerOrderService dao_customerOrder;

    @RequestMapping
    public String getCart(Principal principal) {
        Customer customer = customerService.getCustomerByUsername(principal.getName());
        int cart_id = customer.getCart().getCart_id();

        return "redirect:/customer/cart/" + cart_id;
    }

    @RequestMapping("/{cart_id}")
    public String getCartRedirect(@PathVariable(value = "cart_id") int cart_id, Model model) {
        Cart cart = cartService.getCartById(cart_id);
        model.addAttribute("carts", cart);

        double grandTotal = dao_customerOrder.getCustomerOrderGrandTotal(cart_id);

        model.addAttribute("grandTotal", grandTotal);

        return "cart";
    }

    @RequestMapping(value = "/add/{product_id}", method = RequestMethod.GET)
    public String addItem(@PathVariable(value = "product_id") int product_id, Principal principal) {

        Customer customer = customerService.getCustomerByUsername(principal.getName());

        Cart cart = customer.getCart();
        Product product = productService.getProductById(product_id);
        List<CartItem> cart_items = cart.getCart_items();

        for (CartItem cart_item : cart_items) {
            if (product.getProductId() == cart_item.getproduct().getProductId()) {
                cart_item.setquantity(cart_item.getquantity() + 1);
                cart_item.settotal_price(product.getProductPrice() * cart_item.getquantity());
                cartItemService.addCartItem(cart_item);
                int cart_id = customer.getCart().getCart_id();

                return "redirect:/customer/cart/" + cart_id;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setproduct(product);
        cartItem.setquantity(1);
        cartItem.settotal_price(product.getProductPrice() * cartItem.getquantity());
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);

        int cart_id = customer.getCart().getCart_id();

        return "redirect:/customer/cart/" + cart_id;
    }


    @RequestMapping(value = "/remove/{product_id}", method = RequestMethod.GET)
    public String removeItem(@PathVariable(value = "product_id") int product_id) {
        CartItem cartItem = cartItemService.getCartItemByProductId(product_id);
        cartItemService.removeCartItem(cartItem);

        int cart_id = cartItem.getCart().getCart_id();

        return "redirect:/customer/cart/" + cart_id;
    }

    @RequestMapping(value = "/deleteCart/{cart_id}", method = RequestMethod.GET)
    public String clearCart(@PathVariable(value = "cart_id") int cart_id) {
        Cart cart = cartService.getCartById(cart_id);
        cartItemService.removeAllCartItems(cart);

        return "redirect:/customer/cart/" + cart_id;
    }


}
