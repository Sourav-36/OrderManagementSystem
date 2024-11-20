package com.groceryapp.controllers;

import com.groceryapp.Model.GroceryItem;
import com.groceryapp.Services.GroceryItemService;
import com.groceryapp.dtos.AllGroceryItemResponseDTO;
import com.groceryapp.dtos.GroceryItemResponseDTO;
import com.groceryapp.dtos.GroceryItemRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groceryItems")
public class GroceryItemController {
    private final GroceryItemService groceryItemService;

    @Autowired
    public GroceryItemController(GroceryItemService groceryItemService) {
        this.groceryItemService = groceryItemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItemResponseDTO> getSingleGroceryItem(@PathVariable("id") Long groceryItemId) {
        try{
            GroceryItem groceryItem = groceryItemService.getSingleGroceryItem(groceryItemId);
            return new ResponseEntity<>(
                    new GroceryItemResponseDTO(groceryItem, "Grocery item detail is fetched"),
                    HttpStatus.OK
            );
        } catch(Exception e){
            return new ResponseEntity<>(
                    new GroceryItemResponseDTO(null, e.getMessage()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @GetMapping()
    public ResponseEntity<AllGroceryItemResponseDTO> getAllGroceryItems(){
        try{
            List<GroceryItem> groceryItemsList = groceryItemService.getAllGroceryItems();
            return new ResponseEntity<>(
                    new AllGroceryItemResponseDTO(groceryItemsList, "All Grocery item details are fetched"),
                    HttpStatus.OK
            );
        } catch(Exception e){
            return new ResponseEntity<>(
                    new AllGroceryItemResponseDTO(null, e.getMessage()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/createItem")
    public ResponseEntity<GroceryItemResponseDTO> createGroceryItem(@RequestBody GroceryItemRequestDTO groceryItemRequestDTO) {
        try{
            GroceryItem groceryItem = groceryItemService.createGroceryItem(groceryItemRequestDTO.getName(), groceryItemRequestDTO.getCategory(),
                    groceryItemRequestDTO.getPrice(), groceryItemRequestDTO.getQuantity());
            return new ResponseEntity<>(
                    new GroceryItemResponseDTO(groceryItem, "Grocery item is created"),
                    HttpStatus.OK
            );
        } catch(Exception e){
            return new ResponseEntity<>(
                    new GroceryItemResponseDTO(null, e.getMessage()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GroceryItemResponseDTO> deleteGroceryItem(@PathVariable("id") Long groceryItemId) {
        try{
            groceryItemService.deleteGroceryItem(groceryItemId);
            return new ResponseEntity<>(
                    new GroceryItemResponseDTO(null, "Grocery item is deleted"),
                    HttpStatus.OK
            );
        } catch(Exception e){
            return new ResponseEntity<>(
                    new GroceryItemResponseDTO(null, e.getMessage()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
