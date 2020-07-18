package com.dreamix.travelers.repositories;

import com.dreamix.travelers.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findByIsActiveTrue();
    public User findByEmail(String email);
    public User findByEmailOrUsername(String email, String username);
}
