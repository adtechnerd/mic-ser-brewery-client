package com.futuristic.breweryclient.web.client;

import com.futuristic.breweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
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

    @Test
    void saveBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("new").beerStyle("ALE").upc(123123l).build();
        URI uri = breweryClient.saveBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }
}