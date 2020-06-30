package com.dreamix.travelers.repositories;

import com.dreamix.travelers.data.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
