package com.paypal.order;

import com.paypal.cart.CartDTO;

public class OrderDTO {
    private Long id;
    private CartDTO cartDTO;
    private String status;

    public OrderDTO(Long id, CartDTO cartDTO, String status) {
        this.id = id;
        this.cartDTO = cartDTO;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CartDTO getCartDTO() {
        return cartDTO;
    }

    public void setCartDTO(CartDTO cartDTO) {
        this.cartDTO = cartDTO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", cartDTO=" + cartDTO +
                ", status='" + status + '\'' +
                '}';
    }
}
