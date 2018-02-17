package com.eMusicShopping.dao;

import com.eMusicShopping.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    private List<Product> productList = new ArrayList<Product>();

    public List<Product> getProductList() {
        Product product = new Product();

        product.setProductName("Guitar");
        product.setProductCategory("Instrument");
        product.setProductDescription("This is a fantastic Guitar");
        product.setProductCondition("new");
        product.setProductPrice(1200);
        product.setProductStatus("Active");
        product.setUnitInStock(3);
        product.setProductManufacturer("Yamaha");

        productList.add(product);

        return productList;
    }

    public Product getProductById(int productId) {
        return productList.get(productId);
    }

    public void addProduct(Product product) {

    }
}
