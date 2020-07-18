package com.dreamix.travelers.repositories;

import com.dreamix.travelers.data.ImageAdventure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<ImageAdventure, Long> {
    List<ImageAdventure> findAllByAdventureId(Integer adventureId);
}
