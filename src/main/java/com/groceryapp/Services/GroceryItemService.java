package com.groceryapp.Services;

import com.groceryapp.Model.GroceryItem;

import java.util.List;

public interface GroceryItemService {
    GroceryItem getSingleGroceryItem(Long groceryItemId);
    List<GroceryItem> getAllGroceryItems();
    GroceryItem createGroceryItem(String name, String category, double price, int quantity);
    void deleteGroceryItem(Long groceryItemId);
}
