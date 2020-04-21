package com.paypal.rest;

import com.paypal.product.Product;
import com.paypal.product.ProductDTO;
import com.paypal.repositories.ProductRepository;
import com.paypal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRest {
    private ProductService productService;

    @Autowired
    public ProductRest(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<ProductDTO> products = this.productService.findAll();
        return ResponseEntity.ok(products);
    }

}
