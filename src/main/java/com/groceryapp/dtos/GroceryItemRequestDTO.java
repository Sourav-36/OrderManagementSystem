package com.groceryapp.dtos;

import lombok.Data;

@Data
public class GroceryItemRequestDTO {
    private String name;
    private String category;
    private double price;
    private int quantity;

}
