package com.dreamix.travelers.bootstrap;

import com.dreamix.travelers.data.Adventure;
import com.dreamix.travelers.data.City;
import com.dreamix.travelers.data.User;
import com.dreamix.travelers.repositories.AdventureRepository;
import com.dreamix.travelers.repositories.CityRepository;
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
//        User doni = new User("doni", "doni@d", "blabla", "Doni", "P", true);
//        doni = userRepository.save(doni);
//        Adventure viena = new Adventure("Vienna", doni.getId(), 1, LocalDateTime.now(), "Piite bira", LocalDateTime.now(), Boolean.FALSE);
//        adventureRepository.save(viena);
//
//        Set<Adventure> asd = new HashSet<Adventure>();
//        asd.add(viena);
//        doni.setAdventures(asd);
//
//
//        User denis = new User("ivan", "ivan@d", "blabla", "Ivan", "D", true);
//        userRepository.save(denis);
//        Adventure viena2 = new Adventure("Vienna", denis.getId(), 1, LocalDateTime.now(), "Qjte shniceli", LocalDateTime.now(), Boolean.FALSE);
//        adventureRepository.save(viena2);
//        denis.getAdventures().add(viena2);

        System.out.println("Start ----> [Bootstrap] ");
        System.out.println("Number of adventures " + adventureRepository.count());


    }
}
