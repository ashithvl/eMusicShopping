package com.eMusicShopping.dao;

import com.eMusicShopping.model.Cart;

import java.util.List;

public interface ICartDao {

    void create(Cart cart);

    Cart read(String cartId);

    List<Cart> readAll();

    void update(Cart cart);

    void delete(String cartId);
}
