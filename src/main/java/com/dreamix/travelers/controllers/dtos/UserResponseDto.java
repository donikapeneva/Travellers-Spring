package com.dreamix.travelers.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDto {
    private Integer id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean isActive;
}
