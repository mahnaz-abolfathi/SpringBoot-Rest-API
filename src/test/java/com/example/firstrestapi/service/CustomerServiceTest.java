package com.example.firstrestapi.service;

import com.example.firstrestapi.model.Customer;
import com.example.firstrestapi.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;
//    @InjectMocks
//    CustomerService customerService;


    // methodName_ShouldReturnX_When
    // below test does not using mock object
    @Test
    void getCustomerById_ValidId_ShouldReturnCustomer() {
        CustomerService customerService = new CustomerService(new CustomerRepository());
        long id = 1;
        Customer customer = customerService.getCustomerById(id);
        assertThat(customer.getId()).isEqualTo(1L);
        assertThat(customer.getName()).isEqualTo("Reza");
        assertThat(customer.getLastName()).isEqualTo("Ahmadi");
    }

    @Test
    void getCustomerById_ValidId_ShouldReturnCustomer_WithMock() {
        Customer mockCustomer = new Customer(23L,
                "Adi",
                "Ahmadi",
                LocalDate.of(2023, 6, 21));

        when(customerRepository.getCustomerById(anyLong())).thenReturn(mockCustomer);
        CustomerService customerService = new CustomerService(customerRepository);
        long id = 23;
        Customer customer = customerService.getCustomerById(id);
        assertThat(customer.getId()).isEqualTo(23L);
        assertThat(customer.getName()).isEqualTo("Adi");
        assertThat(customer.getLastName()).isEqualTo("Ahmadi");
    }
}