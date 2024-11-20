package com.groceryapp.dtos;

import com.groceryapp.Model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerResponseDTO {
    private Customer customer;
    private String message;
}
