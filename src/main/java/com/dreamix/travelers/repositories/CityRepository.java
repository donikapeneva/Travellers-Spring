package com.dreamix.travelers.repositories;

import com.dreamix.travelers.data.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {
    List<City> findAllByCountryId (int countryId);
}
