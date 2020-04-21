package com.paypal.mappers;

import com.paypal.cart.Cart;
import com.paypal.cart.CartDTO;
import com.paypal.cart.cartProduct.CartProductDTO;
import com.paypal.repositories.CartProductRepository;
import com.paypal.repositories.CartRepository;
import com.paypal.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CartMapper {
    public static CartDTO toDTO(Cart cart) {
        Long cartID = cart.getId();

        List<CartProductDTO> cartProductDTOS = cart.getCartProducts()
                .stream()
                .map(CartProductMapper::toDTO)
                .collect(Collectors.toList());

        BigDecimal result = cartProductDTOS.stream()
                .map(CartProductDTO::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new CartDTO(cartID, cartProductDTOS, result);
    }

}