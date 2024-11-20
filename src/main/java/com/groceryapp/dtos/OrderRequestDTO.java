package com.groceryapp.dtos;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {
    private Long customerId;
    private List<Long> groceryItemsId;
}
