package com.dreamix.travelers.controllers;

import com.dreamix.travelers.data.Adventure;
import com.dreamix.travelers.services.AdventureService;
import com.dreamix.travelers.utility.request.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/adventures"})
public class AdventureController {
    @Autowired
    private AdventureService adventureService;

    @GetMapping
    //todo: AdventureResponse
    public List<Adventure> getAdventures(SearchCriteria searchCriteria) {
        System.out.println(">>>>>>>>>>" + searchCriteria);

        if (searchCriteria.isEmpty()) {
            return adventureService.getAll();
        } else {
            return adventureService.getBySearchCriteria(searchCriteria);
        }
    }

    @GetMapping("/{id}")
    public Adventure getById(@PathVariable int id) {
        return adventureService.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Adventure create(@RequestBody Adventure adventure) {
        return adventureService.create(adventure);
    }

    @PutMapping("{adventureId}")
    public Adventure update(@PathVariable int adventureId, @RequestBody Adventure updated) {
        return adventureService.update(updated, adventureId);
    }

    @DeleteMapping("{adventureId}")
    public void delete(@PathVariable int adventureId) {
        adventureService.delete(adventureId);
    }


}
