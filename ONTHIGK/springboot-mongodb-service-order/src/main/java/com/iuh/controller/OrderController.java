package com.iuh.controller;

import com.iuh.config.RestTemplateConfig;
import com.iuh.model.Order;
import com.iuh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService service;
    @Autowired
    private RestTemplateConfig restTemplate;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@RequestBody Order order){
        return service.addOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return service.findAllOrder();
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable String orderId){
        return service.getOrderByid(orderId);
    }

    @GetMapping("/v2/{orderId}")
    public Object getOrderCustomer(@PathVariable String orderId) {
        Order order = service.getOrderByid(orderId);
        String customerId = order.getCustomerId();
        // Gọi API khác dựa vào customerId
        String url = "http://localhost:8084/customers/" + customerId;
        return restTemplate.getForObject(url, Object.class);
    }

    @DeleteMapping("/{orderId}")
    public String deleteOrder(@PathVariable String orderId){
       return service.deleteOrder(orderId);
    }
}
