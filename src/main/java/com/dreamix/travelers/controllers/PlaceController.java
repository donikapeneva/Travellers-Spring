package com.dreamix.travelers.controllers;

import com.dreamix.travelers.controllers.dtos.CityDto;
import com.dreamix.travelers.controllers.dtos.CountryDto;
import com.dreamix.travelers.data.City;
import com.dreamix.travelers.data.Country;
import com.dreamix.travelers.services.CityService;
import com.dreamix.travelers.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlaceController {

    @Autowired
    CountryService countryService;

    @Autowired
    CityService cityService;

    @GetMapping
    @RequestMapping("/countries")
    public List<CountryDto> getAllCountries() {
        return this.countryService.getAllCountries();
    }

    @GetMapping
    @RequestMapping("/countries/{countryId}")
    public CountryDto getCountryById(@PathVariable int countryId) {
        return this.countryService.getById(countryId);
    }

    @GetMapping
    @RequestMapping("/countries/{countryId}/cities")
    public List<CityDto> getCitiesByCountryId(@PathVariable int countryId) {
        return this.cityService.getCitiesByCountryId(countryId);
    }

    @GetMapping
    @RequestMapping("/cities")
    public List<CityDto> getAllCities() {
        return this.cityService.getAllCities();
    }


}
