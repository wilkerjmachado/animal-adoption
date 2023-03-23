package com.animals.challenge.repository;

import com.animals.challenge.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalTypeRepository extends JpaRepository<Partner, Long> {

}
