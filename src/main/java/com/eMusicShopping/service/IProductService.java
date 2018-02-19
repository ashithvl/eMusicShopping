package com.eMusicShopping.service;

import com.eMusicShopping.model.Product;

import java.util.List;

public interface IProductService {

    void addProduct(Product product);

    void editProduct(Product product);

    Product getProductById(int id);

    List getAllProducts();

    void deleteProduct(int id);
}
