package com.dreamix.travelers.controllers;

import com.dreamix.travelers.data.Adventure;
import com.dreamix.travelers.data.User;
import com.dreamix.travelers.services.AdventureService;
import com.dreamix.travelers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdventureService adventureService;

    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllActive();
    }

    @GetMapping
    @RequestMapping("/{userId}")
    public User get(@PathVariable int userId) {
        return this.userService.getById(userId);
    }

    @GetMapping
    @RequestMapping("/{userId}/adventures")
    public List<Adventure> getAdventuresByUserId(@PathVariable int userId) {
        return this.adventureService.getByUserId(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{userId}")
    public User update(@PathVariable int userId, @RequestBody User updated) {
        return userService.update(updated, userId);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable int userId) {
        //TODO: update, not actual delete
        userService.delete(userId);
    }


}
