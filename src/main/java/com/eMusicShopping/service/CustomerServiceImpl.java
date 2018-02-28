package com.eMusicShopping.service;

import com.eMusicShopping.dao.ICustomerDao;
import com.eMusicShopping.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    ICustomerDao iCustomerDao;

    @Override
    public void addCustomer(Customer customer) {
        iCustomerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int customerId) {
        return iCustomerDao.getCustomerById(customerId);
    }

    @Override
    public Customer getCustomerByUsername(String customerName) {
        return iCustomerDao.getCustomerByUsername(customerName);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return iCustomerDao.getAllCustomers();
    }

    @Override
    public Customer checkPin(String pin, String option) {
        return iCustomerDao.checkPin(pin,option);
    }
}
