package com.paypal.rest;

import com.paypal.cart.Cart;
import com.paypal.cart.CartDTO;
import com.paypal.repositories.CartRepository;
import com.paypal.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/savedCarts")
public class CartRest {
    private CartService cartService;

    @Autowired
    public CartRest(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<List<CartDTO>> findAll() {
        List<CartDTO> list = this.cartService.findAll();
        return ResponseEntity.ok(list);
    }
}
