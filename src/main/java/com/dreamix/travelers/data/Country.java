package com.dreamix.travelers.data;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String country_code;

    @OneToMany(mappedBy = "country")
    private Set<City> cities;

    public Country() {};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }
//
//    public Set<City> getCities() {
//        return cities;
//    }
//
//    public void setCities(Set<City> cities) {
//        this.cities = cities;
//    }
}
