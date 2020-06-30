package com.dreamix.travelers.controllers;

import com.dreamix.travelers.data.Adventure;
import com.dreamix.travelers.services.AdventureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/"})
public class HomeController {
    @Autowired
    private AdventureService adventureService;

    @GetMapping
    public List<Adventure> getAll(){
        return adventureService.getAll();
    }
}
