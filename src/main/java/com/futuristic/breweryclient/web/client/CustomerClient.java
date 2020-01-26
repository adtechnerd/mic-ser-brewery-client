package com.futuristic.breweryclient.web.client;

import com.futuristic.breweryclient.web.model.CustomerDto;
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
@ConfigurationProperties("micserv.brewery")
public class CustomerClient {

    private final String CUSTOMER_PATH = "/api/v1/customer/";

    private String apihost;

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomerById(UUID uuid) {
        CustomerDto customerDto = restTemplate.getForObject(apihost + CUSTOMER_PATH + uuid.toString(), CustomerDto.class);
        return customerDto;
    }

    public URI saveCustomer(CustomerDto customerDto) {
        URI uri = restTemplate.postForLocation(apihost + CUSTOMER_PATH, customerDto);
        return uri;
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto) {
        restTemplate.put(apihost + CUSTOMER_PATH + uuid.toString(), customerDto);
    }

    public void deleteCustomer(UUID uuid) {
        restTemplate.delete(apihost + CUSTOMER_PATH + uuid.toString());
    }
}
