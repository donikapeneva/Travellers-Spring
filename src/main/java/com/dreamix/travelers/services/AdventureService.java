package com.dreamix.travelers.services;

import com.dreamix.travelers.data.Adventure;
import com.dreamix.travelers.repositories.AdventureRepository;
import com.dreamix.travelers.utility.AdventureSpecifications;
import com.dreamix.travelers.utility.Utility;
import com.dreamix.travelers.utility.request.FilterByRules;
import com.dreamix.travelers.utility.request.SortByRules;
import com.dreamix.travelers.utility.request.SearchCriteria;
import com.dreamix.travelers.utility.responce.AdventureResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdventureService {
    @Autowired
    private AdventureRepository adventureRepository;

    public List<Adventure> getAll() {
        return this.adventureRepository.findAll();
    }

    public Adventure getById(int id) {
        Optional<Adventure> adventure = this.adventureRepository.findById(id);

        if(adventure.isPresent()){
            return adventure.get();
        }

        return null;
    }

    public List<Adventure> getByUserId(int userId) {
        return this.adventureRepository.findAllByUserId(userId);
    }

    public List<Adventure> getBySearchCriteria(SearchCriteria search) {

        AdventureSpecifications specifications = new AdventureSpecifications(search);
        Specification<Adventure> adventureSpecificSearch = specifications.getSpecifiedCriteria();

        List<Adventure> result = adventureRepository.findAll(adventureSpecificSearch);


        if(search.getSortByUser() != null) {
//            result = result.sort();
        }

        if(search.getSortByCity() != null) {
//            result = result.sort();
        }

        if(search.getSortByCountry() != null) {
//            result = result.sort();
        }

        if(search.getSortByDate() != null) {
//            result = result.sort();
        }

        return result;

    }

    public Adventure create(Adventure newAdventure) {
        newAdventure.setLast_updated(LocalDateTime.now());
        Adventure adventure = adventureRepository.saveAndFlush(newAdventure);
        return adventure;
    }

    public void delete(int id) {
        Optional<Adventure> record = adventureRepository.findById(id);
        if(record.isPresent()) {
            Adventure adventure = record.get();
            adventure.setIs_deleted(true);
            adventure.setLast_updated(LocalDateTime.now());
            //TODO: check
            adventureRepository.flush();
        }
    }

    public Adventure update(Adventure updatedAdventure, int id) {
        Optional<Adventure> record = adventureRepository.findById(id);

        if(!record.isPresent()) {
            return null;
        }

        Adventure adventure = record.get();
        adventure.setName(updatedAdventure.getName());
        adventure.setTip(updatedAdventure.getTip());
        adventure.setTime(updatedAdventure.getTime());
        adventure.setCity_id(updatedAdventure.getCity_id());
        adventure.setLast_updated(LocalDateTime.now());
        adventureRepository.flush();
        return adventure;
    }

}
