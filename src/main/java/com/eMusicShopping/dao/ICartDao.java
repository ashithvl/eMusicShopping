package com.eMusicShopping.dao;

import com.eMusicShopping.model.Cart;

import java.io.IOException;

/**
 * Created by dario on 26/10/2016.
 */
public interface ICartDao {

    Cart getCartById(int cart_id);

    void update(Cart cart);

    Cart validate(int cart_id) throws IOException;


}
