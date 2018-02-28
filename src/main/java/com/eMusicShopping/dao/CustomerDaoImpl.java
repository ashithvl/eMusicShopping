package com.eMusicShopping.dao;

import com.eMusicShopping.model.Authorities;
import com.eMusicShopping.model.Cart;
import com.eMusicShopping.model.Customer;
import com.eMusicShopping.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerDaoImpl implements ICustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        customer.getBillingAddress().setCustomer(customer);
        customer.getShippingAddress().setCustomer(customer);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(customer.getBillingAddress());
        session.saveOrUpdate(customer.getShippingAddress());

        Users newUsers = new Users();
        newUsers.setUsername(customer.getCustomer_username());
        newUsers.setPassword(customer.getCustomer_password());
        newUsers.setCustomer_id(customer.getCustomer_id());
        newUsers.setEnabled(true);

        Authorities newAuthorities = new Authorities();
        newAuthorities.setUsername(customer.getCustomer_username());
        newAuthorities.setAuthority("ROLE_USER");

        session.saveOrUpdate(newUsers);
        session.saveOrUpdate(newAuthorities);

        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        customer.setCart(newCart);

        session.saveOrUpdate(customer);
        session.saveOrUpdate(newCart);

        session.flush();

    }

    @Override
    public Customer getCustomerById(int customerId) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, customerId);
        session.flush();
        return customer;
    }

    @Override
    public List<Customer> getAllCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer");
        List<Customer> customerList = query.list();

        session.flush();
        return customerList;
    }

    @Override
    public Customer getCustomerByUsername(String customerName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where customer_username = :customerName");
        query.setParameter("customerName", customerName);
        Customer customer = (Customer) query.uniqueResult();

        session.flush();
        return customer;
    }

    @Override
    public Customer checkPin(String pin, String option) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Customer where pin = :pin AND pin_alg= :pin_alg");
        query.setParameter("pin", pin);
        query.setParameter("pin_alg", option);
        Customer customer = (Customer) query.uniqueResult();

        session.flush();
        return customer;
    }
}