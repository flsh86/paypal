package com.paypal.cart.cartProduct;

import com.paypal.cart.Cart;
import com.paypal.product.Product;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class CartProduct {
    @EmbeddedId
    private CartProductPK cartProductPK;

    @Column(nullable = false)
    private Integer quantity;

    public CartProduct() {
    }

    public CartProduct(Cart cart, Product product, Integer quantity) {
        this.cartProductPK = new CartProductPK();
        this.cartProductPK.setCart(cart);
        this.cartProductPK.setProduct(product);
        this.quantity = quantity;
    }

    public CartProductPK getCartProductPK() {
        return cartProductPK;
    }

    public void setCartProductPK(CartProductPK cartProductPK) {
        this.cartProductPK = cartProductPK;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartProduct)) return false;

        CartProduct that = (CartProduct) o;

        if (getCartProductPK() != null ? !getCartProductPK().equals(that.getCartProductPK()) : that.getCartProductPK() != null)
            return false;
        return getQuantity() != null ? getQuantity().equals(that.getQuantity()) : that.getQuantity() == null;
    }

    @Override
    public int hashCode() {
        int result = getCartProductPK() != null ? getCartProductPK().hashCode() : 0;
        result = 31 * result + (getQuantity() != null ? getQuantity().hashCode() : 0);
        return result;
    }
}
