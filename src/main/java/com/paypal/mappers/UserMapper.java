package com.paypal.mappers;

import com.paypal.cart.CartDTO;
import com.paypal.order.OrderDTO;
import com.paypal.user.User;
import com.paypal.user.UserDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        Long id = user.getId();
        String name = user.getName();
        String surname = user.getSurname();
        List<CartDTO> savedCarts = user.getCarts().stream()
                .map(CartMapper::toDTO)
                .collect(Collectors.toList());
        List<OrderDTO> purchased = user.getOrders().stream()
                .map(OrderMapper::toDTO)
                .collect(Collectors.toList());
        return new UserDTO(id, name, surname, savedCarts, purchased);
    }
}
