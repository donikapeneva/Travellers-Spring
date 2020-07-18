package com.dreamix.travelers.controllers.mappers;

import com.dreamix.travelers.controllers.dtos.AdventureDto;
import com.dreamix.travelers.controllers.dtos.ImageResponseDto;
import com.dreamix.travelers.controllers.dtos.UserResponseDto;
import com.dreamix.travelers.data.Adventure;
import com.dreamix.travelers.data.ImageAdventure;
import com.dreamix.travelers.data.User;
import com.dreamix.travelers.utility.ImageBase64Utility;
import org.apache.tomcat.util.codec.binary.Base64;

public class RecordToDto {

    public static AdventureDto AdventureRecordToAdventureDto(Adventure adventureRecord) {

        return new AdventureDto(adventureRecord.getId(), adventureRecord.getName(), adventureRecord.getUserId(),
                adventureRecord.getCityId(), adventureRecord.getTime().toString(), adventureRecord.getTip());
    }

    public static UserResponseDto UserRecordToUserDto(User user) {
        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getIsActive());
    }

    public static ImageResponseDto UserRecordToUserDto(ImageAdventure image) {
        byte[] byteArray = Base64.encodeBase64(image.getSource());
        String imageAsBase64 = ImageBase64Utility.generateBase64ImageFromSourceAndContentType(new String(byteArray), image.getType());

        return new ImageResponseDto(image.getId(), image.getAdventureId(), image.getTitle(), imageAsBase64);
    }

}
