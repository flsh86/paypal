package com.paypal.repositories;

import com.paypal.cart.cartProduct.CartProduct;
import com.paypal.cart.cartProduct.CartProductPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartProductRepository extends JpaRepository<CartProduct, CartProductPK> {

}
