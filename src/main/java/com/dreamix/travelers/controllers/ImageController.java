package com.dreamix.travelers.controllers;

import com.dreamix.travelers.controllers.dtos.ImageRequestDto;
import com.dreamix.travelers.controllers.dtos.ImageResponseDto;
import com.dreamix.travelers.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping(value = "/images/{adventureId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Long uploadImage(@PathVariable("adventureId") String adventureId, @RequestBody ImageRequestDto image) {
        Long imageId = imageService.upload(adventureId, image);

        return imageId;
    }


    @GetMapping(value = "/images/{adventureId}")
    public List<ImageResponseDto> getImages(@PathVariable("adventureId") String adventureId) {
        List<ImageResponseDto> images = imageService.findImageByAdventureId(adventureId);

        return images;
    }

    @DeleteMapping(path = {"/images/{imageId}"})
    public void getImage(@PathVariable("imageId") String id) {
        imageService.deleteById(id);
    }

    @GetMapping(value = "/images/{adventureId}/cover")
    public ImageResponseDto getCoverImage(@PathVariable("adventureId") String adventureId) {
        ImageResponseDto image = imageService.getCoverImage(adventureId);


        return image;
    }
}
