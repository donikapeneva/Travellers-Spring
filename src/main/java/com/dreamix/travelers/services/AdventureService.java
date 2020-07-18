package com.dreamix.travelers.services;

import com.dreamix.travelers.controllers.dtos.AdventureDto;
import com.dreamix.travelers.controllers.exceptionHandling.CustomBadRequestException;
import com.dreamix.travelers.controllers.mappers.RecordToDto;
import com.dreamix.travelers.data.Adventure;
import com.dreamix.travelers.repositories.AdventureRepository;
import com.dreamix.travelers.utility.AdventureSpecifications;
import com.dreamix.travelers.utility.SortByValidSpecifications;
import com.dreamix.travelers.utility.Utility;
import com.dreamix.travelers.utility.request.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AdventureService {
    @Autowired
    private AdventureRepository adventureRepository;

    @Autowired
    private AdventureValidationService adventureValidationService;

    public List<AdventureDto> getAll() {
        List<Adventure> adventuresRecords = this.adventureRepository.findAll();

        List<AdventureDto> adventures = adventuresRecords.stream()
                .map(RecordToDto::AdventureRecordToAdventureDto)
                .collect(Collectors.toList());

        return adventures;
    }

    public AdventureDto getById(int id) {
        Optional<Adventure> adventureRecord = this.adventureRepository.findById(id);

        if (adventureRecord.isPresent()) {
            Adventure adventure = adventureRecord.get();

            return RecordToDto.AdventureRecordToAdventureDto(adventure);
        }

        return null;
    }

    public List<AdventureDto> getByUserId(int userId) {
        List<Adventure> adventureRecords = this.adventureRepository.findAllByUserId(userId);
        List<AdventureDto> adventures = adventureRecords.stream()
                .map(RecordToDto::AdventureRecordToAdventureDto)
                .collect(Collectors.toList());

        return adventures;
    }

    public List<AdventureDto> getBySearchCriteria(SearchCriteria search) {

        AdventureSpecifications specifications = new AdventureSpecifications(search);
        Specification<Adventure> adventureSpecificSearch = specifications.getSpecifiedCriteria();

        List<Adventure> adventureRecords = adventureRepository.findAll(adventureSpecificSearch);

        Comparator<AdventureDto> comparator = comparatorBasedOnSearchCriteria(search);

        Stream<AdventureDto> adventureDtoStream = adventureRecords.stream()
                .map(RecordToDto::AdventureRecordToAdventureDto);

        if (comparator != null) {
            adventureDtoStream.sorted(comparator);
        }

        List<AdventureDto> adventures = adventureDtoStream.collect(Collectors.toList());

        return adventures;

    }

    public AdventureDto create(AdventureDto newAdventure) {

        Adventure adventure = new Adventure();

        adventure.setName(newAdventure.getName());
        adventure.setCityId(newAdventure.getCityId());
        adventure.setUserId(newAdventure.getUserId());

        //  todo move to utility
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(newAdventure.getTime());
        } catch (Exception x) {
            throw new CustomBadRequestException("Invalid date is passed. Supported date format: yyyy-MM-dd'T'HH:mm:ss");

        }

        LocalDateTime ldt = Instant.ofEpochMilli(date.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();

        adventure.setTime(ldt);
        adventure.setTip(newAdventure.getTip());
        adventure.setLastUpdated(LocalDateTime.now());
        adventure.setIsDeleted(false);

        adventureValidationService.validateOnCreate(adventure);

        Adventure createdAdventure = adventureRepository.saveAndFlush(adventure);

        return RecordToDto.AdventureRecordToAdventureDto(createdAdventure);
    }

    public void delete(int id) {
        Optional<Adventure> record = adventureRepository.findById(id);
        if (record.isPresent()) {
            Adventure adventure = record.get();
            adventure.setIsDeleted(true);
            adventure.setLastUpdated(LocalDateTime.now());
            adventureRepository.flush();
        }
    }

    public AdventureDto update(AdventureDto updatedAdventure, int id) {
        Optional<Adventure> record = adventureRepository.findById(id);

        if (!record.isPresent()) {
            return null;
        }

        Adventure adventure = record.get();
        adventure.setName(updatedAdventure.getName());
        adventure.setTip(updatedAdventure.getTip());
        adventure.setTime(Utility.stringToLocalDateTime(updatedAdventure.getTime()));
        adventure.setCityId(updatedAdventure.getCityId());
        adventure.setLastUpdated(LocalDateTime.now());
        adventureRepository.flush();

        return RecordToDto.AdventureRecordToAdventureDto(adventure);
    }

    private Comparator<AdventureDto> comparatorBasedOnSearchCriteria(SearchCriteria search) {
        if (search.getSortBy() == null) {
            return null;
        }

        Comparator<AdventureDto> comparator = null;

        if (SortByValidSpecifications.ADVENTURE_NAME.getValue().equalsIgnoreCase(search.getSortBy())) {
            comparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        } else if (SortByValidSpecifications.DATE.getValue().equalsIgnoreCase(search.getSortBy())) {
            comparator = (o1, o2) -> o1.getTime().compareTo(o2.getTime());
        } else if (SortByValidSpecifications.DATE_DESC.getValue().equalsIgnoreCase(search.getSortBy())) {
            comparator = (o1, o2) -> o2.getTime().compareTo(o1.getTime());
        }

        return comparator;
    }


}
