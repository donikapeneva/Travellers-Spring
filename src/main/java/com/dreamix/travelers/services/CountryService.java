package com.dreamix.travelers.services;

import com.dreamix.travelers.controllers.dtos.CountryDto;
import com.dreamix.travelers.controllers.mappers.RecordToDto;
import com.dreamix.travelers.data.Country;
import com.dreamix.travelers.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    public List<CountryDto> getAllCountries() {
        List<Country> countryRecords = this.countryRepository.findAll();
        List<CountryDto> countries = countryRecords.stream().map(RecordToDto::CountryRecordToCountryDto).collect(Collectors.toList());
        return countries;
    }

    public CountryDto getById(int id) {
        Optional<Country> countryRecord = this.countryRepository.findById(id);

        if(countryRecord.isPresent()) {
            CountryDto country = RecordToDto.CountryRecordToCountryDto(countryRecord.get());
            return country;
        } else {
            return null;
        }

    }


}
