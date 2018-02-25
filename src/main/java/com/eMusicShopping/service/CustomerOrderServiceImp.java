package com.eMusicShopping.service;

import com.eMusicShopping.dao.ICustomerOrderDao;
import com.eMusicShopping.model.Cart;
import com.eMusicShopping.model.CartItem;
import com.eMusicShopping.model.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dario on 10/11/2016.
 */
@Service
public class CustomerOrderServiceImp implements ICustomerOrderService {

    @Autowired
    private ICustomerOrderDao dao_customerOrder;

    @Autowired
    private ICartService cartService;

    public void addCustomerOrder(CustomerOrder customerOrder) {
        dao_customerOrder.addCustomerOrder(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cart_id) {
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cart_id);
        List<CartItem> cartItems = cart.getCart_items();

        for (CartItem item : cartItems) {
            grandTotal += item.gettotal_price();
        }

        return grandTotal;
    }
}
