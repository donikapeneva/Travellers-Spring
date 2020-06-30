package com.dreamix.travelers.repositories;

import com.dreamix.travelers.data.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
