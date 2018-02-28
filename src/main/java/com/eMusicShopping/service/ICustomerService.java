package com.eMusicShopping.service;

import com.eMusicShopping.model.Customer;

import java.util.List;

public interface ICustomerService {

    void addCustomer(Customer customer);

    Customer getCustomerById(int customerId);

    Customer getCustomerByUsername(String customerName);

    List<Customer> getAllCustomers();

    Customer checkPin(String pin, String option);

}
