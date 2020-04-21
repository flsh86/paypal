package com.paypal.cart;

import com.paypal.cart.cartProduct.CartProductDTO;

import java.math.BigDecimal;
import java.util.List;

public class CartDTO {
    private Long cartID;
    private List<CartProductDTO> productDTOS;
    private BigDecimal checkOutPrice;

    public CartDTO(Long cartID, List<CartProductDTO> productDTOS, BigDecimal checkOutPrice) {
        this.cartID = cartID;
        this.productDTOS = productDTOS;
        this.checkOutPrice = checkOutPrice;
    }

    public Long getCartID() {
        return cartID;
    }

    public void setCartID(Long cartID) {
        this.cartID = cartID;
    }

    public List<CartProductDTO> getProductDTOS() {
        return productDTOS;
    }

    public void setProductDTOS(List<CartProductDTO> productDTOS) {
        this.productDTOS = productDTOS;
    }

    public BigDecimal getCheckOutPrice() {
        return checkOutPrice;
    }

    public void setCheckOutPrice(BigDecimal checkOutPrice) {
        this.checkOutPrice = checkOutPrice;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "cartID=" + cartID +
                ", productDTOS=" + productDTOS +
                ", checkOutPrice=" + checkOutPrice +
                '}';
    }
}