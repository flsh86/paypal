package com.paypal.mappers;

import com.paypal.cart.cartProduct.CartProduct;
import com.paypal.cart.cartProduct.CartProductDTO;
import com.paypal.repositories.CartProductRepository;
import com.paypal.repositories.CartRepository;
import com.paypal.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CartProductMapper {
    public static CartProductDTO toDTO(CartProduct cartProduct) {
        String productName = cartProduct.getCartProductPK().getProduct().getName();
        BigDecimal productPrice = cartProduct.getCartProductPK().getProduct().getPrice();
        Integer quantity = cartProduct.getQuantity();

        return new CartProductDTO(productName, productPrice, quantity);
    }

}
