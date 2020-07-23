package com.dreamix.travelers.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityDto {
    private Integer id;
    private String name;
    private Integer countryId;
    private CountryDto country;
}
