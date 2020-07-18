package com.dreamix.travelers.services;

import com.dreamix.travelers.controllers.exceptionHandling.CustomBadRequestException;
import com.dreamix.travelers.data.Adventure;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdventureValidationService {
    public void validateOnCreate(Adventure newAdventure) {
        boolean isNameValid = newAdventure.getName() != null;
        boolean isUserIdValid = newAdventure.getUserId() != null;
        boolean isCityIdValid = newAdventure.getCityId() != null;
        boolean isTipValid = newAdventure.getTip() != null;
        //todo getUser_id() should be assigned from user session/context

        List<String> exceptionMessages = new ArrayList<String>();

        if(!isNameValid) {
            exceptionMessages.add("Param name is invalid.");
        }

        if(!isUserIdValid) {
            exceptionMessages.add("Param userID is invalid.");
        }

        if(!isCityIdValid) {
            exceptionMessages.add("Param isCityId is invalid.");
        }

        if(!isTipValid) {
            exceptionMessages.add("Param tip is invalid.");
        }

        if(!exceptionMessages.isEmpty()) {
            throw new CustomBadRequestException(String.join(" ", exceptionMessages));
        }
    }
}
