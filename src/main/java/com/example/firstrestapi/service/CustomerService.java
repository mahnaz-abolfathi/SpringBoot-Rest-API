package com.example.firstrestapi.service;

import com.example.firstrestapi.model.Customer;
import com.example.firstrestapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.addCustomer(customer);
    }
    public Customer getCustomerById(Long id){
       return customerRepository.getCustomerById(id);
    }

}
