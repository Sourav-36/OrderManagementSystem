package com.groceryapp.dtos;

import com.groceryapp.Model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AllOrderResponseDTO {
    private List<Order> orders;
    private String message;
}
