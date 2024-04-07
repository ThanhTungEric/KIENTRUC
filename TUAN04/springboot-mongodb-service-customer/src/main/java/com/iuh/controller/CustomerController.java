package com.iuh.controller;

import com.iuh.model.Customer;
import com.iuh.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers(){
        return service.findAllCustomer();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable String customerId){
        return service.getCustomerByid(customerId);
    }

    @DeleteMapping("/{customerId}")
    public String deleteCustomer(@PathVariable String customerId){
       return service.deleteCustomer(customerId);
    }
}
