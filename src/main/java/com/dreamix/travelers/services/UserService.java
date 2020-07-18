package com.dreamix.travelers.services;

import com.dreamix.travelers.controllers.dtos.UserRequestDto;
import com.dreamix.travelers.controllers.dtos.UserResponseDto;
import com.dreamix.travelers.controllers.exceptionHandling.CustomBadRequestException;
import com.dreamix.travelers.controllers.mappers.DtoToRecord;
import com.dreamix.travelers.controllers.mappers.RecordToDto;
import com.dreamix.travelers.data.User;
import com.dreamix.travelers.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserResponseDto> getAllActive() {
        List<User> userRecords = this.userRepository.findByIsActiveTrue();

        return userRecords.stream().map(RecordToDto::UserRecordToUserDto).collect(Collectors.toList());
    }

    public UserResponseDto getById(Integer id) {
        Optional<User> user = this.userRepository.findById(id);

        if (user.isPresent()) {
            return RecordToDto.UserRecordToUserDto(user.get());
        }

        return null;
    }

    public UserResponseDto create(UserRequestDto newUser) {
        validateOnCreate(newUser);
        User record = userRepository.findByEmailOrUsername(newUser.getEmail(), newUser.getUsername());

        if (record != null) {
            throw new CustomBadRequestException("Username or mail already exist");
        }

        User user = DtoToRecord.UserRequestDtoToUserRecord(newUser);
        user.setIsActive(true);

        user = userRepository.saveAndFlush(user);

        return RecordToDto.UserRecordToUserDto(user);
    }

    public void delete(int id) {
        Optional<User> record = userRepository.findById(id);

        if (record.isPresent()) {
            User user = record.get();
            user.setIsActive(false);

            userRepository.flush();
        }
    }

    public UserResponseDto update(UserRequestDto updatedUser, int id) {
        Optional<User> record = userRepository.findById(id);

        if (!record.isPresent()) {
            return null;
        }

        User user = record.get();
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setFirstName(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());

        userRepository.flush();

        return RecordToDto.UserRecordToUserDto(user);
    }

    private void validateOnCreate(UserRequestDto newUser) {
        boolean isUsernameValid = newUser.getUsername() != null;
        boolean isEmailValid = newUser.getEmail() != null;
        boolean isPassValid = newUser.getPassword() != null;
        boolean isFirstNameValid = newUser.getFirstName() != null;
        boolean isLastNameValid = newUser.getLastName() != null;

        List<String> exceptionMessages = new ArrayList<String>();

        if (!isUsernameValid) {
            exceptionMessages.add("Param username or password is not invalid.");
        }

        if (!isEmailValid) {
            exceptionMessages.add("Param email is invalid.");
        }

        if (!isPassValid) {
            exceptionMessages.add("Param username or password is not invalid.");
        }

        if (!isFirstNameValid) {
            exceptionMessages.add("Param firstName is invalid.");
        }

        if (!isLastNameValid) {
            exceptionMessages.add("Param lastName is invalid.");
        }

        if (!exceptionMessages.isEmpty()) {
            throw new CustomBadRequestException(String.join(" ", exceptionMessages));
        }
    }
}
