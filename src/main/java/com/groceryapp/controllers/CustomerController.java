package com.groceryapp.controllers;

import com.groceryapp.Model.Customer;
import com.groceryapp.Services.CustomerService;
import com.groceryapp.dtos.AllCustomerResponseDTO;
import com.groceryapp.dtos.CustomerRequestDTO;
import com.groceryapp.dtos.CustomerResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getSingleCustomer(@PathVariable("id") Long customerId){
        try {
            Customer response = customerService.getSingleCustomer(customerId);
            return new ResponseEntity<>(
                    new CustomerResponseDTO(response, "Customer details is fetched"),
                    HttpStatus.OK
            );
        } catch(Exception e){
            return new ResponseEntity<>(
                    new CustomerResponseDTO(null, e.getMessage()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @GetMapping()
    public ResponseEntity<AllCustomerResponseDTO> getAllCustomers(){
        try {
            List<Customer> responses = customerService.getAllCustomers();
            return new ResponseEntity<>(
                    new AllCustomerResponseDTO(responses, "All customer details are fetched"),
                    HttpStatus.OK
            );
        } catch(Exception e){
            return new ResponseEntity<>(
                    new AllCustomerResponseDTO(null, e.getMessage()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerResponseDTO> addCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        try {
            Customer response = customerService.addCustomer(customerRequestDTO.getName(), customerRequestDTO.getEmail(),
                    customerRequestDTO.getPhone(), customerRequestDTO.getAddress());
            return new ResponseEntity<>(
                    new CustomerResponseDTO(response, "Customer is created"),
                    HttpStatus.OK
            );
        } catch(Exception e){
            return new ResponseEntity<>(
                    new CustomerResponseDTO(null, e.getMessage()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> deleteCustomer(@PathVariable("id") Long customerId){
        try {
            customerService.deleteCustomer(customerId);
            return new ResponseEntity<>(
                    new CustomerResponseDTO(null, "Customer is deleted"),
                    HttpStatus.OK
            );
        } catch(Exception e){
            return new ResponseEntity<>(
                    new CustomerResponseDTO(null, e.getMessage()),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
