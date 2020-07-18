package com.dreamix.travelers.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImageResponseDto {
    private long id;
    private int adventureId;
    private String title;
    private String sourceBase64;
}
