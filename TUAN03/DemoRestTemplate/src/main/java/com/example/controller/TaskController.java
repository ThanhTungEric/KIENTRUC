package com.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class TaskController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/product")
    public Object getForObject(){
        String url = "http://localhost:8082/products";
        return restTemplate.getForObject(url, Object.class);
    }

    @GetMapping("/order")
    public Object getForObjectOder(){
        String url = "http://localhost:8083/orders";
        return restTemplate.getForObject(url, Object.class);
    }

}
