package com.groceryapp.controllers;

import com.groceryapp.Model.Order;
import com.groceryapp.Services.OrderService;
import com.groceryapp.dtos.AllOrderResponseDTO;
import com.groceryapp.dtos.OrderRequestDTO;
import com.groceryapp.dtos.OrderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrder(@PathVariable("id") Long orderId){
        try{
            Order order = orderService.getOrder(orderId);
            return new ResponseEntity<>(
                    new OrderResponseDTO(order, "Order has been fetched"),
                    HttpStatus.OK
            );
        } catch(Exception e){
            return new ResponseEntity<>(
                    new OrderResponseDTO(null, e.getMessage()),
                    HttpStatus.BAD_GATEWAY
            );
        }
    }

    @GetMapping()
    public ResponseEntity<AllOrderResponseDTO> getAllOrders(){
        try{
            List<Order> orders = orderService.getAllOrders();
            return new ResponseEntity<>(
                    new AllOrderResponseDTO(orders, "All orders has been fetched"),
                    HttpStatus.OK
            );
        } catch(Exception e){
            return new ResponseEntity<>(
                    new AllOrderResponseDTO(null, e.getMessage()),
                    HttpStatus.BAD_GATEWAY
            );
        }
    }

    @PostMapping("/createOrder")
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        try{
            Order order = orderService.createOrder(orderRequestDTO.getCustomerId(), orderRequestDTO.getGroceryItemsId());
            return new ResponseEntity<>(
                    new OrderResponseDTO(order, "Order has been created"),
                    HttpStatus.OK
            );
        } catch(Exception e){
            return new ResponseEntity<>(
                    new OrderResponseDTO(null, e.getMessage()),
                    HttpStatus.BAD_GATEWAY
            );
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> deleteOrder(@PathVariable("id") Long orderId){
        try{
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>(
                    new OrderResponseDTO(null, "Order has been deleted"),
                    HttpStatus.OK
            );
        } catch(Exception e){
            return new ResponseEntity<>(
                    new OrderResponseDTO(null, e.getMessage()),
                    HttpStatus.BAD_GATEWAY
            );
        }
    }

}
