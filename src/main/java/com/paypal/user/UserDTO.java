package com.paypal.user;

import com.paypal.cart.CartDTO;
import com.paypal.order.OrderDTO;

import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private List<CartDTO> savedCarts;
    private List<OrderDTO> purchased;

    public UserDTO(Long id, String name, String surname, List<CartDTO> savedCarts, List<OrderDTO> purchased) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.savedCarts = savedCarts;
        this.purchased = purchased;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<CartDTO> getSavedCarts() {
        return savedCarts;
    }

    public void setSavedCarts(List<CartDTO> savedCarts) {
        this.savedCarts = savedCarts;
    }

    public List<OrderDTO> getPurchased() {
        return purchased;
    }

    public void setPurchased(List<OrderDTO> purchased) {
        this.purchased = purchased;
    }
}
