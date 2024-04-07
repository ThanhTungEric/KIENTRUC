package com.iuh.service;

import com.iuh.model.Order;
import com.iuh.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order addOrder(Order order){
        order.setOrderId(UUID.randomUUID().toString().split("-")[0]);
        return orderRepository.save(order);
    }

    public List<Order> findAllOrder(){
        return orderRepository.findAll();
    }

    public Order getOrderByid(String orderId){
        return orderRepository.findById(orderId).get();
    }

    public String deleteOrder(String orderId){
        orderRepository.deleteById(orderId);
        return orderId+" order deleted from database";
    }

}
