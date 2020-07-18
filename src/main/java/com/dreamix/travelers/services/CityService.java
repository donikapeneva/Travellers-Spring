package com.dreamix.travelers.services;

import com.dreamix.travelers.data.City;
import com.dreamix.travelers.repositories.CityRepository;
import com.dreamix.travelers.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public List<City> getCitiesByCountryId (int countryId) {
        List<City> allByCountryId = cityRepository.findAllByCountryId(countryId);
        return allByCountryId;
    }

}
