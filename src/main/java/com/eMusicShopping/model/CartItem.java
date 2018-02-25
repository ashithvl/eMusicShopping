package com.eMusicShopping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by dario on 26/10/2016.
 */

@Entity
public class CartItem implements Serializable{

    private static final long serialVersionUID = -5425701670023632251L;

    @Id
    @GeneratedValue
    private int cartItem_id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    @JsonIgnore
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int cantidad;
    private double precio_total;

    public int getCartItem_id() {
        return cartItem_id;
    }

    public void setCartItem_id(int cartItem_id) {
        this.cartItem_id = cartItem_id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getproduct() {
        return product;
    }

    public void setproduct(Product product) {
        this.product = product;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(double precio_total) {
        this.precio_total = precio_total;
    }
}
