package com.dreamix.travelers.controllers;

import com.dreamix.travelers.data.City;
import com.dreamix.travelers.data.Country;
import com.dreamix.travelers.services.CityService;
import com.dreamix.travelers.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class PlaceController {

    @Autowired
    CountryService countryService;

    @Autowired
    CityService cityService;

    @GetMapping
    public List<Country> getAllCountries() {
        return this.countryService.getAllCountries();
    }

    @GetMapping
    @RequestMapping("/{countryId}")
    public Country getCountryById(@PathVariable int countryId) {
        return this.countryService.getById(countryId);
    }

    @GetMapping
    @RequestMapping("/{countryId}/cities")
    public List<City> getCitiesByCountryId(@PathVariable int countryId) {
        return this.cityService.getCitiesByCountryId(countryId);
    }


}
