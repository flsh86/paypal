package com.paypal.cart;

import com.paypal.cart.cartProduct.CartProduct;
import com.paypal.cart.cartProduct.CartProductPK;
import com.paypal.product.Product;
import com.paypal.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Cart {
    @Id
    private Long id;

    @OneToMany(mappedBy = "cartProductPK.cart")
    private List<CartProduct> cartProducts = new ArrayList<>();

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;

        Cart cart = (Cart) o;

        return getId() != null ? getId().equals(cart.getId()) : cart.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
