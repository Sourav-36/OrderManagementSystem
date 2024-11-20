package com.groceryapp.Services;

import com.groceryapp.Model.Customer;
import com.groceryapp.Model.GroceryItem;
import com.groceryapp.Model.Order;
import com.groceryapp.Repositories.CustomerRepository;
import com.groceryapp.Repositories.GroceryItemRepository;
import com.groceryapp.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final GroceryItemRepository groceryItemRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository, GroceryItemRepository groceryItemRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.groceryItemRepository = groceryItemRepository;
    }

    @Override
    public Order createOrder(Long customerId, List<Long> groceryItemsIds){
        Optional<Customer> customerCheck = customerRepository.findById(customerId);
        if(customerCheck.isEmpty()){
            throw new RuntimeException("Customer not found");
        }
        Customer customer = customerCheck.get();

        List<GroceryItem> groceryItemsList = new ArrayList<>();
        double totalPrice = 0.0;
        for(Long groceryItemId : groceryItemsIds){
            Optional<GroceryItem> groceryItemCheck = groceryItemRepository.findById(groceryItemId);
            if(groceryItemCheck.isEmpty()){
                throw new RuntimeException("Grocery item not found");
            }

            groceryItemsList.add(groceryItemCheck.get());
            totalPrice += groceryItemCheck.get().getPrice() * groceryItemCheck.get().getQuantity();
        }

        return orderRepository.save(new Order(customer, groceryItemsList, new Date(), totalPrice));

    }

    @Override
    public Order getOrder(Long orderId){
        Optional<Order> orderCheck = orderRepository.findById(orderId);
        if(orderCheck.isEmpty()){
            throw new RuntimeException("Order not found");
        }

        return orderCheck.get();
    }

    @Override
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(Long orderId){
        Optional<Order> orderCheck = orderRepository.findById(orderId);
        if(orderCheck.isEmpty()){
            throw new RuntimeException("Order not found");
        }

        orderRepository.deleteById(orderId);
    }
}
