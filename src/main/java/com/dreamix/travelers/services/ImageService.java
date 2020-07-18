package com.dreamix.travelers.services;


import com.dreamix.travelers.controllers.dtos.ImageResponseDto;
import com.dreamix.travelers.controllers.mappers.RecordToDto;
import com.dreamix.travelers.data.ImageAdventure;
import com.dreamix.travelers.controllers.dtos.ImageRequestDto;
import com.dreamix.travelers.repositories.ImageRepository;
import com.dreamix.travelers.utility.ImageBase64Utility;
import com.dreamix.travelers.utility.ImageInfoBase64;
import com.dreamix.travelers.utility.Utility;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;


    public Long upload(String adventureId, ImageRequestDto imageRequestDTO) {
        ImageInfoBase64 imageInfo = ImageBase64Utility.getImageSourceAndContentTypeFromBase64String(imageRequestDTO.getSource());
        byte[] byteArray = Base64.decodeBase64(imageInfo.getSource());

        ImageAdventure img = new ImageAdventure(imageRequestDTO.getTitle(), imageInfo.getContentType(), byteArray, Utility.stringToInteger(adventureId));
        ImageAdventure imageAdventure = imageRepository.saveAndFlush(img);

        return imageAdventure.getId();
    }

    public List<ImageResponseDto> findImageByAdventureId(String id) {
        List<ImageAdventure> images =  imageRepository.findAllByAdventureId(Utility.stringToInteger(id));

        List<ImageResponseDto> imagesBase64 = images.stream()
                                                    .map(RecordToDto::UserRecordToUserDto)
                                                    .collect(Collectors.toList());

        return imagesBase64;
    }

    public void deleteById(String id) {
        imageRepository.deleteById(Utility.stringToLong(id));
    }

}
