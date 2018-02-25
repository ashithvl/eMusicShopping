package com.eMusicShopping.service;

import com.eMusicShopping.dao.ICartItemDao;
import com.eMusicShopping.model.Cart;
import com.eMusicShopping.model.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dario on 08/11/2016.
 */
@Service
public class CartItemServiceImp implements ICartItemService {

    @Autowired
    private ICartItemDao dao_cartItem;

    public void addCartItem(CartItem cartItem) {
        dao_cartItem.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        dao_cartItem.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart) {
        dao_cartItem.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProductId(int producto_id) {
        return dao_cartItem.getCartItemByProductId(producto_id);
    }

}
