package com.dreamix.travelers.controllers.mappers;

import com.dreamix.travelers.controllers.dtos.*;
import com.dreamix.travelers.data.*;
import com.dreamix.travelers.utility.ImageBase64Utility;
import org.apache.tomcat.util.codec.binary.Base64;

public class RecordToDto {

    public static AdventureDto AdventureRecordToAdventureDto(Adventure adventureRecord) {
        City cityRecord = adventureRecord.getCity();
        Country countryRecord = cityRecord.getCountry();
        CountryDto country = new CountryDto(countryRecord.getId(), countryRecord.getName(), countryRecord.getCountryCode());

        CityDto city = new CityDto(cityRecord.getId(), cityRecord.getName(), cityRecord.getCountryId(), country);
        return new AdventureDto(adventureRecord.getId(), adventureRecord.getName(), adventureRecord.getUserId(),
                adventureRecord.getCityId(), adventureRecord.getTime().toString(), adventureRecord.getTip(), city);
    }

    public static UserResponseDto UserRecordToUserDto(User user) {
        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getIsActive());
    }

    public static ImageResponseDto ImageRecordToImageDto(ImageAdventure image) {
        if(image == null) {
            return null;
        }
        byte[] byteArray = Base64.encodeBase64(image.getSource());
        String imageAsBase64 = ImageBase64Utility.generateBase64ImageFromSourceAndContentType(new String(byteArray), image.getType());

        return new ImageResponseDto(image.getId(), image.getAdventureId(), image.getTitle(), imageAsBase64);
    }


    public static CityDto CityRecordToCityDto(City city) {
        Country countryRecord = city.getCountry();
        CountryDto country = CountryRecordToCountryDto(countryRecord);
        return new CityDto(city.getId(), city.getName(), city.getCountryId(), country);
    }

    public static CountryDto CountryRecordToCountryDto(Country country) {
        return new CountryDto(country.getId(), country.getName(), country.getCountryCode());
    }

}
