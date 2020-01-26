package com.futuristic.breweryclient.web.client;

import com.futuristic.breweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    private CustomerClient customerClient;

    @Test
    void getCustomerById() {
        CustomerDto customerById = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerById);
    }

    @Test
    void saveCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("KIng").id(UUID.randomUUID()).build();
        URI uri = customerClient.saveCustomer(customerDto);
        assertNotNull(uri);

    }

    @Test
    void updateCustomer() {
        UUID uuid = UUID.randomUUID();
        CustomerDto customerDto = CustomerDto.builder().name("King").id(UUID.randomUUID()).build();
        customerClient.updateCustomer(uuid, customerDto);
    }

    @Test
    void deleteCustomer() {
        UUID uuid = UUID.randomUUID();
        customerClient.deleteCustomer(uuid);
    }
}