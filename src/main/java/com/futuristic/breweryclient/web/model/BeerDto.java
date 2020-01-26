package com.futuristic.breweryclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * aditya created on 26/01/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    private String beerName;
    private String beerStyle;
    private UUID uuid;
    private Long upc;
}
