package com.dreamix.travelers.services;

import com.dreamix.travelers.controllers.dtos.CityDto;
import com.dreamix.travelers.controllers.mappers.RecordToDto;
import com.dreamix.travelers.data.City;
import com.dreamix.travelers.repositories.CityRepository;
import com.dreamix.travelers.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    public List<CityDto> getCitiesByCountryId (int countryId) {
        List<City> allByCountryId = cityRepository.findAllByCountryId(countryId);
        List<CityDto> cities = allByCountryId.stream().map(RecordToDto::CityRecordToCityDto).collect(Collectors.toList());
        return cities;
    }

    public List<CityDto> getAllCities () {
        List<City> all = cityRepository.findAll();
        List<CityDto> cities = all.stream().map(RecordToDto::CityRecordToCityDto).collect(Collectors.toList());
        return cities;
    }

}
