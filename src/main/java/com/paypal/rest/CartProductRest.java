package com.paypal.rest;

import com.paypal.cart.cartProduct.CartProductDTO;
import com.paypal.service.CartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/savedProducts")
public class CartProductRest {
    private CartProductService cartProductService;

    @Autowired
    public CartProductRest(CartProductService cartProductService) {
        this.cartProductService = cartProductService;
    }

    @GetMapping
    public ResponseEntity<List<CartProductDTO>> findAll() {
        List<CartProductDTO> dto = this.cartProductService.findAll();
        return ResponseEntity.ok(dto);
    }
}
