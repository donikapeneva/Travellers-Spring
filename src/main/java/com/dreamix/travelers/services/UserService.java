package com.dreamix.travelers.services;

import com.dreamix.travelers.data.User;
import com.dreamix.travelers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllActive() {
        return this.userRepository.findByIsActiveTrue();
    }

    public User getById(Integer id) {
        Optional<User> user = this.userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    public User create(User newUser) {
        //todo UserDTO
        User record = userRepository.findByEmail(newUser.getEmail());
        if(record != null) {
            return null;
        }
        newUser.setActive(true);
        User user = userRepository.saveAndFlush(newUser);

        return user;
    }

    public void delete(int id) {
        Optional<User> record = userRepository.findById(id);
        if(record.isPresent()) {
            User user = record.get();
            user.setActive(false);

            userRepository.flush();
        }
    }

    public User update(User updatedUser, int id) {
        Optional<User> record = userRepository.findById(id);
        if(!record.isPresent()) {
            return null;
        }

        User user = record.get();
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());

        userRepository.flush();

        return user;
    }
}
