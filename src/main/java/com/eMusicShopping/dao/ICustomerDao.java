package com.eMusicShopping.dao;

import com.eMusicShopping.model.Customer;

import java.util.List;

public interface ICustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String customerName);

    Customer checkPin(String pin, String option);

    String getMD5(String input);

    public String SHA256(String password);

    public String PBKDF2WithHmacSHA1(String password, String salt);

}
