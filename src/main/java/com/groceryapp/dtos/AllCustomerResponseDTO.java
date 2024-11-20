package com.groceryapp.dtos;

import com.groceryapp.Model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AllCustomerResponseDTO {
    private List<Customer> customers;
    private String message;
}
