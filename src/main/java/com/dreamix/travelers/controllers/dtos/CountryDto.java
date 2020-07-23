package com.dreamix.travelers.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryDto {
    private Integer id;
    private String name;
    private String countryCode;
}
