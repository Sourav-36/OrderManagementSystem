package com.groceryapp.Services;

import com.groceryapp.Model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer getSingleCustomer(Long customerId);
    public List<Customer> getAllCustomers();
    public Customer addCustomer(String name, String email, String address, String phone);
    public void deleteCustomer(Long customerId);

}
