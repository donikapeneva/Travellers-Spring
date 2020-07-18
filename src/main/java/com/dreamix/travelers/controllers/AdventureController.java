package com.dreamix.travelers.controllers;

import com.dreamix.travelers.controllers.dtos.AdventureDto;
import com.dreamix.travelers.services.AdventureService;
import com.dreamix.travelers.utility.request.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//import com.sun.javaws.exceptions.InvalidArgumentException;

@RestController
@RequestMapping({"/adventures"})
public class AdventureController {
    @Autowired
    private AdventureService adventureService;

    @GetMapping
    //todo: AdventureResponse
    public List<AdventureDto> getAdventures(SearchCriteria searchCriteria) {
        if (searchCriteria.isEmpty()) {
            //todo sorted by date
            return adventureService.getAll();
        } else {
            return adventureService.getBySearchCriteria(searchCriteria);
        }
    }

    @GetMapping("/{id}")
    public AdventureDto getById(@PathVariable int id) {
        return adventureService.getById(id);
    }


    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public AdventureDto create(@RequestBody AdventureDto adventure) {

        AdventureDto newAdventure = null;
        newAdventure = adventureService.create(adventure);

        return newAdventure;
    }


    @PutMapping("{adventureId}")
    public AdventureDto update(@PathVariable int adventureId, @RequestBody AdventureDto updated) {
        return adventureService.update(updated, adventureId);
    }


    @DeleteMapping("{adventureId}")
    public void delete(@PathVariable int adventureId) {
        adventureService.delete(adventureId);
    }


}
