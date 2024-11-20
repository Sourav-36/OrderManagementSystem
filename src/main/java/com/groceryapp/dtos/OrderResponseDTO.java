package com.groceryapp.dtos;

import com.groceryapp.Model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponseDTO {
    private Order order;
    private String message;
}
