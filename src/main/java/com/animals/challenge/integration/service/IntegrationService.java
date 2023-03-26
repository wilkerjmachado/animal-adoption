package com.animals.challenge.integration.service;

import com.animals.challenge.integration.client.IntegrationCatClient;
import com.animals.challenge.integration.client.IntegrationDogClient;
import com.animals.challenge.integration.dto.ResponseAnimalDto;
import com.animals.challenge.model.Animal;
import com.animals.challenge.service.AnimalService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Service
public class IntegrationService {

    private IntegrationDogClient integrationDogClient;

    private IntegrationCatClient integrationCatClient;

    private AnimalService animalService;

    private Environment environment;

    public void index() {

        List<ResponseAnimalDto> responseCats = this.integrationCatClient.getBreads(this.environment.getProperty("app.integration.api.cat.key"));

        List<ResponseAnimalDto> responseDogs = this.integrationDogClient.getBreads(this.environment.getProperty("app.integration.api.dog.key"));

        List<Animal> animalListToSave = responseCats.stream().map(cat -> cat.toAnimal(Animal.Category.CAT)).collect(Collectors.toList());

        animalListToSave.addAll(responseDogs.stream().map(dog -> dog.toAnimal(Animal.Category.DOG)).collect(Collectors.toList()));

        this.animalService.saveAll(animalListToSave);

    }

}
