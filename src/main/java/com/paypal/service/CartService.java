package com.paypal.service;

import com.paypal.cart.Cart;
import com.paypal.cart.CartDTO;
import com.paypal.mappers.CartMapper;
import com.paypal.repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<CartDTO> findAll() {
        List<Cart> carts = this.cartRepository.findAll();

        return carts
                .stream()
                .map(CartMapper::toDTO)
                .collect(Collectors.toList());
    }


}
