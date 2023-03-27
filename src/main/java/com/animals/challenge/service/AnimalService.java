package com.animals.challenge.service;

import com.animals.challenge.dto.AnimalDto;
import com.animals.challenge.exception.ServiceException;
import com.animals.challenge.model.Animal;
import com.animals.challenge.repository.AnimalRepository;
import com.animals.challenge.repository.specification.AnimalSpecification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Getter
@AllArgsConstructor
@Service
public class AnimalService extends BaseService<Animal, AnimalDto> {

    private AnimalRepository repository;

    @Override
    protected Specification<Animal> getSpecification(String term, AnimalDto filters) {

        return AnimalSpecification.builder().filters(filters).term(term).build();
    }

    @Override
    protected void validate(Animal entity) {

        super.validate(entity);

        if (this.getRepository().existsByName(entity.getName())) {

            throw new ServiceException("Animal exists");
        }
    }
}
