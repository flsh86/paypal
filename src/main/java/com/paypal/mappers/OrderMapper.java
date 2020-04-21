package com.paypal.mappers;

import com.paypal.cart.CartDTO;
import com.paypal.order.Order;
import com.paypal.order.OrderDTO;

public class OrderMapper {

    public static OrderDTO toDTO(Order order) {
        Long id = order.getId();
        CartDTO cartDTO = CartMapper.toDTO(order.getCart());
        String status = order.getOrderStatus().name();
        return new OrderDTO(id, cartDTO, status);
    }

}
