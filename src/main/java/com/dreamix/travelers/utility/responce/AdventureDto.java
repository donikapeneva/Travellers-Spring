package com.dreamix.travelers.utility.responce;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdventureDto {
    private Integer id;
    private String name;
    private Integer user_id;
    private Integer city_id;
    private LocalDateTime time;
    private String tip;
    private LocalDateTime last_updated;
//    private Boolean is_deleted;


}
