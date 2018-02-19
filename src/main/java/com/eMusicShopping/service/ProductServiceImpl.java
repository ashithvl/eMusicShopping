package com.eMusicShopping.service;

import com.eMusicShopping.dao.IProductDao;
import com.eMusicShopping.dao.ProductDaoImpl;
import com.eMusicShopping.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    public void addProduct(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public void editProduct(Product product) {
       productDao.editProduct(product);
    }

    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    public List getAllProducts() {
        return productDao.getAllProducts();
    }

    public void deleteProduct(int id) {
        productDao.deleteProduct(id);
    }
}
