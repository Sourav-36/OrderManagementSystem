package com.groceryapp.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseModel{
    @ManyToOne
    private Customer customer;
    @ManyToMany
    @JoinTable(
            name = "order_grocery",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "groceryitem_id")
    )
    private List<GroceryItem> groceryItem;
    private Date orderDate;
    private double totalPrice;
}
