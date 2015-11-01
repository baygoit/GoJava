/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gojava6.cart;


import com.gojava6.entity.Product;

/**
 *
 * @author tgiunipero
 */
public class ShoppingCartItem {

    Product product;
    short quantity;

    public ShoppingCartItem(Product product) {
        this.product = product;
        quantity = 1;
    }

    public Product getProduct() {
        return product;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public double getTotal() {
        double amount = 0;
        amount = (this.getQuantity() * product.getPrice().doubleValue());
        return amount;
    }

}