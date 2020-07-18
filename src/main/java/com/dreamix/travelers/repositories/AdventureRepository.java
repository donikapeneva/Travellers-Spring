package com.dreamix.travelers.repositories;

import com.dreamix.travelers.data.Adventure;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AdventureRepository extends JpaRepository<Adventure, Integer>, JpaSpecificationExecutor {

    public List<Adventure> findAllByUserId(int userId);
    public List<Adventure> findAllByOrderByTimeDesc();
//    public List<Adventure> findAllByCity_id(int cityId);

}
