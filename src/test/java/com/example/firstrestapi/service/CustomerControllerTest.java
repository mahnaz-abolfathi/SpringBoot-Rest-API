package com.example.firstrestapi.service;

import com.example.firstrestapi.controller.CustomerController;
import com.example.firstrestapi.model.Customer;
import com.example.firstrestapi.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

//@ActiveProfiles("dev")
@WebMvcTest(CustomerController.class) // Specify the controller to test
//    @AutoConfigureMockMvc
//    @TestPropertySource(locations = "classpath:application-dev.properties")
//    @TestPropertySource(properties = {"server.servlet.context-path=/customer-api"})
class CustomerControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    CustomerService customerService;
    @MockBean
    CustomerRepository customerRepository;


    @Test
    void getCustomerById_ValidId_ShouldReturnCustomer_WithMock() throws Exception {
        Customer mockCustomer = new Customer(23L,
                "Adi",
                "Ahmadi",
                LocalDate.of(2023, 6, 21));

        when(customerRepository.getCustomerById(anyLong())).thenReturn(mockCustomer);
        when(customerService.getCustomerById(anyLong())).thenReturn(mockCustomer);

        // Perform the request and verify the result
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/customers/23"))
//        mockMvc.perform(MockMvcRequestBuilders.get("/v1/customers/test"))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"))
                ;
    }
}