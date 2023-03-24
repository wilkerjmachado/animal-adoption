package com.animals.challenge.service;

import com.animals.challenge.model.Animal;
import com.animals.challenge.repository.AnimalRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@AllArgsConstructor
@Service
public class AnimalService extends BaseService<Animal>{

    private AnimalRepository repository;

}
