package com.eMusicShopping.dao;

import com.eMusicShopping.model.Cart;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CartDaoImpl implements ICartDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Cart cart) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
        session.flush();//to execute;
    }

    @Override
    public Cart read(String cartId) {
        Session session = sessionFactory.getCurrentSession();
        Cart cart = (Cart) session.get(Cart.class, cartId);
        session.flush();
        return cart;
    }

    @Override
    public List<Cart> readAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Cart");
        List<Cart> cartList = query.list();
        session.flush();
        return cartList;
    }

    @Override
    public void update(Cart cart) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
        session.flush();//to execute
    }

    @Override
    public void delete(String cartId) {
        Session session = sessionFactory.getCurrentSession();
        Cart cart = (Cart) session.load(Cart.class, cartId);
        if (cart != null)
            session.delete(cart);
        session.flush();
    }

}
