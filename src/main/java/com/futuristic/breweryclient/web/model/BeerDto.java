package com.futuristic.breweryclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.util.UUID;

/**
 * aditya created on 26/01/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {

    @NotNull
    private String beerName;

    @NotNull
    private String beerStyle;

    @Null
    private UUID uuid;

    @Positive
    private Long upc;
}
