package com.dreamix.travelers.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdventureDto {
    private Integer id;
    private String name;
    private Integer userId;
    private Integer cityId;
    private String time;
    private String tip;
}
