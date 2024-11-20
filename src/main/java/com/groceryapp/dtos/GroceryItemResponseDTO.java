package com.groceryapp.dtos;

import com.groceryapp.Model.GroceryItem;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GroceryItemResponseDTO {
    private GroceryItem groceryItem;
    private String message;
}

