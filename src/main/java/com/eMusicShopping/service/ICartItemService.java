package com.eMusicShopping.service;

import com.eMusicShopping.model.Cart;
import com.eMusicShopping.model.CartItem;

/**
 * Created by dario on 08/11/2016.
 */
public interface ICartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int producto_id);
}
