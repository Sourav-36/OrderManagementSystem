package com.groceryapp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groceryitems")
public class GroceryItem extends BaseModel{
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    private double price;
    private int quantity;
}
