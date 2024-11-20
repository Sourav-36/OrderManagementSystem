package com.groceryapp.Services;

import com.groceryapp.Model.Category;
import com.groceryapp.Model.GroceryItem;
import com.groceryapp.Repositories.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemServiceImpl implements GroceryItemService {

    private final GroceryItemRepository groceryItemRepository;

    @Autowired
    public GroceryItemServiceImpl(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    @Override
    public GroceryItem createGroceryItem(String name, String category, double price, int quantity) {
        return groceryItemRepository.save(new GroceryItem(name, Category.getCategoryType(category.toUpperCase()), price, quantity));
    }

    @Override
    public GroceryItem getSingleGroceryItem(Long groceryItemId) {
        Optional<GroceryItem> groceryItemCheck = groceryItemRepository.findById(groceryItemId);
        if(groceryItemCheck.isEmpty()) {
            throw new RuntimeException("Grocery Item Not Found");
        }

        return groceryItemCheck.get();
    }

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    @Override
    public void deleteGroceryItem(Long groceryItemId) {
        Optional<GroceryItem> groceryItemCheck = groceryItemRepository.findById(groceryItemId);
        if(groceryItemCheck.isEmpty()) {
            throw new RuntimeException("Grocery Item Not Found");
        }

        groceryItemRepository.deleteById(groceryItemId);
    }

}
