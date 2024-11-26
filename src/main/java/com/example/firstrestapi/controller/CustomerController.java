package com.example.firstrestapi.controller;

import com.example.firstrestapi.model.Customer;
import com.example.firstrestapi.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

//    get, -> get customer info -> input: id or other fields
//    post, -> create or add new customer -> a customer without id
//    put,  -> update existing customer -> id + updated customer obj
//    patch, -> update existing customer some fields -> id + updated field
//    delete -> remove existing customer -> input: id

//89.101.251.228     https://www.profource.com/en/
//192.168.1.1:9090/v1/customers/1          localhsot
@Slf4j
@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    @Operation(summary = "Insert a new Customer", description = "Returns a Customer")
    @CrossOrigin(origins = "http://localhost:8080", methods = {RequestMethod.POST})
    public Customer addCustomer(@RequestBody Customer customer) {
        log.info("Adding customer={}", customer);
        return customerService.addCustomer(customer);
    }

    @GetMapping(path = "/{id}")
    @CrossOrigin(origins = "http://localhost:8080", methods = {RequestMethod.GET})
    public ResponseEntity<Customer> getCustomerById(WebRequest request, @PathVariable(name = "id") Long id) {
        log.info("Getting customer by id={}", id);
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }
    //e.g. http://localhost:9090/customer-api/v1/customers/123

    @GetMapping(path = "/test")
    public Customer test() {
        return customerService.getCustomerById(23L);
    }


}
