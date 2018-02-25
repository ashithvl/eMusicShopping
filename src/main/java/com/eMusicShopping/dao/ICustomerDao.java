package com.eMusicShopping.dao;

import com.eMusicShopping.model.Customer;

import java.util.List;

public interface ICustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String customerName);
}
