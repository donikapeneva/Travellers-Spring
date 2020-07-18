package com.dreamix.travelers.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDto {
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
