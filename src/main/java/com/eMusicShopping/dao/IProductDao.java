package com.eMusicShopping.dao;

import com.eMusicShopping.model.Product;

import java.util.List;

public interface IProductDao {

    void addProduct(Product product);

    void editProduct(Product product);

    Product getProductById(int id);

    List getAllProducts();

    void deleteProduct(int id);

}
