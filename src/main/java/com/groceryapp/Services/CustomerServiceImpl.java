package com.groceryapp.Services;

import com.groceryapp.Model.Customer;
import com.groceryapp.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addCustomer(String name, String email, String address, String phone) {
        return customerRepository.save(new Customer(name, email, address, phone));
    }

    @Override
    public Customer getSingleCustomer(Long customerId) {
        Optional<Customer> customerCheck = customerRepository.findById(customerId);
        if(customerCheck.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }
        return customerCheck.get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Optional<Customer> customerCheck = customerRepository.findById(customerId);
        if(customerCheck.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(customerId);
    }
}
