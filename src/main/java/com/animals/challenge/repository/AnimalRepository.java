package com.animals.challenge.repository;

import com.animals.challenge.model.Animal;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends BaseRepository<Animal> {

    boolean existsByName(String name);
}
