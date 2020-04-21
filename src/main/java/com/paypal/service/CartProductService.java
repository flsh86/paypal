package com.paypal.service;

import com.paypal.cart.cartProduct.CartProduct;
import com.paypal.cart.cartProduct.CartProductDTO;
import com.paypal.mappers.CartProductMapper;
import com.paypal.repositories.CartProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartProductService {
    private CartProductRepository cartProductRepository;

    @Autowired
    public CartProductService(CartProductRepository cartProductRepository) {
        this.cartProductRepository = cartProductRepository;
    }

    public List<CartProductDTO> findAll() {
        List<CartProduct> cartProducts = this.cartProductRepository.findAll();


        return cartProducts.stream()
                .map(CartProductMapper::toDTO)
                .collect(Collectors.toList());
    }

}
