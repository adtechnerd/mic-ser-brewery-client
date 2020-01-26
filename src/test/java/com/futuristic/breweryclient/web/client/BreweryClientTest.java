package com.futuristic.breweryclient.web.client;

import com.futuristic.breweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    private BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerById = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerById);
    }
}