package com.groceryapp.dtos;

import com.groceryapp.Model.GroceryItem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AllGroceryItemResponseDTO {
    private List<GroceryItem> groceryItemList;
    private String message;
}
