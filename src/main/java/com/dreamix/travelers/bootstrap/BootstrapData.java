package com.dreamix.travelers.bootstrap;

import com.dreamix.travelers.repositories.AdventureRepository;
import com.dreamix.travelers.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootstrapData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AdventureRepository adventureRepository;


    public BootstrapData(UserRepository userRepository, AdventureRepository adventureRepository) {
        this.userRepository = userRepository;
        this.adventureRepository = adventureRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("Start ----> [Bootstrap] ");
        System.out.println("Number of adventures " + adventureRepository.count());

    }
}
