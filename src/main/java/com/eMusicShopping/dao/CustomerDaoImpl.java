package com.eMusicShopping.dao;

import com.eMusicShopping.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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

        String hash = null;
        System.out.println("pin "+option);
        if (option.equals("1"))
            hash = getMD5(pin);
        if (option.equals("2"))
            hash = SHA256(pin);
        if (option.equals("3"))
            hash = PBKDF2WithHmacSHA1(pin,"salt");

        Query query = session.createQuery("from Customer where pin = :pin AND pin_alg= :pin_alg");
        query.setParameter("pin", hash);
        query.setParameter("pin_alg", option);
        Customer customer = (Customer) query.uniqueResult();

        session.flush();
        return customer;
    }

    @Override
    public String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            System.out.println("Hex format : " + hashtext.toString());
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            System.out.println("Hex format : " + hashtext.toString());
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String SHA256(String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes("UTF-8"));

            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < hashedBytes.length; i++) {
                stringBuffer.append(Integer.toString((hashedBytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            System.out.println("Hex format SHA256 : " + stringBuffer.toString());
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String PBKDF2WithHmacSHA1(String password, String salt) {

        final int ITERATIONS = 1000;
        final int KEY_LENGTH = 192; // bits

        char[] passwordChars = password.toCharArray();
        byte[] saltBytes = salt.getBytes();

        PBEKeySpec spec = new PBEKeySpec(
                passwordChars,
                saltBytes,
                ITERATIONS,
                KEY_LENGTH
        );
        SecretKeyFactory key = null;
        try {
            key = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hashedPassword = key.generateSecret(spec).getEncoded();
            return String.format("%x", new BigInteger(hashedPassword));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}