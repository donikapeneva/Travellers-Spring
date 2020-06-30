package com.dreamix.travelers.utility.responce;

import lombok.Data;

@Data
public class UserDto {

    private Integer id;
    private String username;
    private String email;
    private String first_name;
    private String last_name;
    private Boolean is_active;

}
