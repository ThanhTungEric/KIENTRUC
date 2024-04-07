package com.iuh.service;

import com.iuh.model.Customer;
import com.iuh.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){
        customer.setCustomerId(UUID.randomUUID().toString().split("-")[0]);
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer getCustomerByid(String customerId){
        return customerRepository.findById(customerId).get();
    }

    public String deleteCustomer(String customerId){
        customerRepository.deleteById(customerId);
        return customerId+" customer deleted from database";
    }

}
