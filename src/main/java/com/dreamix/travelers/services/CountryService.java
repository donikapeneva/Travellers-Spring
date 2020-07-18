package com.dreamix.travelers.services;

import com.dreamix.travelers.data.Country;
import com.dreamix.travelers.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        List<Country> countryRecords = this.countryRepository.findAll();
        return countryRecords;
    }

    public Country getById(int id) {
        Optional<Country> countryRecord = this.countryRepository.findById(id);

        if(countryRecord.isPresent()) {
            return countryRecord.get();
        } else {
            return null;
        }

    }


}
