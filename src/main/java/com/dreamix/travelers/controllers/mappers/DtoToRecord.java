package com.dreamix.travelers.controllers.mappers;

import com.dreamix.travelers.controllers.dtos.AdventureDto;
import com.dreamix.travelers.controllers.dtos.UserRequestDto;
import com.dreamix.travelers.data.Adventure;
import com.dreamix.travelers.data.User;
import com.dreamix.travelers.utility.Utility;

import java.time.LocalDateTime;

public class DtoToRecord {

    public static Adventure AdventureDtoToAdventureRecord(AdventureDto adventureDto) {

        return new Adventure(adventureDto.getId(), adventureDto.getName(), adventureDto.getUserId(),
                adventureDto.getCityId(), Utility.stringToLocalDateTime(adventureDto.getTime()), adventureDto.getTip(),
                LocalDateTime.now(), false, null, null);
    }

    public static User UserRequestDtoToUserRecord(UserRequestDto userRequest) {
        return new User(userRequest.getUsername(), userRequest.getEmail(), userRequest.getPassword(), userRequest.getFirstName(), userRequest.getLastName());
    }
}
