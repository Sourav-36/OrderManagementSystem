package com.groceryapp.Services;

import com.groceryapp.Model.Order;

import java.util.List;

public interface OrderService {
    Order getOrder(Long orderId);
    List<Order> getAllOrders();
    Order createOrder(Long customerId, List<Long> groceryItemsId);
    void deleteOrder(Long orderId);

}
