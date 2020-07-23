package com.dreamix.travelers.controllers;

import com.dreamix.travelers.controllers.dtos.AdventureDto;
import com.dreamix.travelers.controllers.dtos.UserRequestDto;
import com.dreamix.travelers.controllers.dtos.UserResponseDto;
import com.dreamix.travelers.services.AdventureService;
import com.dreamix.travelers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdventureService adventureService;

    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return this.userService.getAllActive();
    }

    @GetMapping
    @RequestMapping("/{userId}")
    public UserResponseDto get(@PathVariable int userId) {
        return this.userService.getById(userId);
    }

    @GetMapping
    @RequestMapping("/{userId}/adventures")
    public List<AdventureDto> getAdventuresByUserId(@PathVariable int userId) {
        return this.adventureService.getByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@RequestBody UserRequestDto user) {
        UserResponseDto newUser = userService.create(user);

        return newUser;
    }

    @PutMapping("/{userId}")
    public UserResponseDto update(@PathVariable int userId, @RequestBody UserRequestDto updates) {

        return userService.update(updates, userId);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable int userId) {
        userService.delete(userId);
    }


}
