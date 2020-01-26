package com.futuristic.breweryclient.web.client;

import com.futuristic.breweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * aditya created on 26/01/20
 */
@Component
@ConfigurationProperties(value = "micserv.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH = "/api/v1/beer/";
    private String apihost;
    private final RestTemplate restTemplate;
    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDto getBeerById(UUID uuid) {
        return restTemplate.getForObject(apihost + BEER_PATH + UUID.randomUUID().toString(), BeerDto.class);
    }

    public URI saveBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(apihost+BEER_PATH , beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto) {
        restTemplate.put(apihost + BEER_PATH + UUID.randomUUID().toString(), beerDto);
    }

    public void deleteBeer(UUID uuid) {
        restTemplate.delete(apihost + BEER_PATH + uuid);
    }
}
