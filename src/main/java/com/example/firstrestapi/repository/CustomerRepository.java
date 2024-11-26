package com.example.firstrestapi.repository;

import com.example.firstrestapi.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


//@Component
@Repository
public class CustomerRepository {

    public static Map<Long, Customer> customerMap = new HashMap<>();

    //todo: Later we can use an actual DataBase instead of Map (e.g. h2 database)
    public CustomerRepository() {
        Customer reza = new Customer(1L, "Reza", "Ahmadi", LocalDate.of(1979, 8, 24));
        Customer mahnaz = new Customer(2L, "Mahnaz", "Abolfathi", LocalDate.of(1985, 12, 23));
        customerMap.put(reza.getId(), reza);
        customerMap.put(mahnaz.getId(), mahnaz);
    }

    public Customer addCustomer(Customer customer){
        return customerMap.put(customer.getId(), customer);
    }

    public Customer getCustomerById(Long id) {
        return customerMap.get(id);
    }

}
