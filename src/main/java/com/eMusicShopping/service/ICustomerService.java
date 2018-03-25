package com.eMusicShopping.service;

import com.eMusicShopping.model.Customer;

import java.util.List;

public interface ICustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    Customer getCustomerByUsername(String customerName);

    List<Customer> getAllCustomers();

    Customer checkPin(String pin, String option);

    String getMD5(String input);

    String SHA256(String password);

    String PBKDF2WithHmacSHA1(String password, String salt);
}
