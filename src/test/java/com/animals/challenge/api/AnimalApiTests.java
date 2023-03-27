package com.animals.challenge.api;

import com.animals.challenge.dto.AnimalDto;
import com.animals.challenge.integration.service.IntegrationService;
import com.animals.challenge.model.Animal;
import com.animals.challenge.service.AnimalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AnimalApiTests {

    @Mock
    private AnimalService service;

    @Mock
    private IntegrationService integrationService;

    @InjectMocks
    private AnimalApi animalApi;

    @Test
    public void whenCallIndex_thenAnimalsShouldBeCreated() {

        var response = animalApi.index();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void whenUpdateStatus_thenAnimalShouldBeUpdatedStatus() {

        Long animalId = 1L;

        var mockAnimal = Animal.builder()
                .name("Affenpinscher")
                .image("https://cdn2.thedogapi.com/images/BJa4kxc4X.jpg")
                .integrationId("1")
                .status(Animal.Status.ADOPTED)
                .category(Animal.Category.DOG)
                .description("Small rodent hunting, lapdog")
                .build();
        mockAnimal.setId(animalId);

        when(service.save(any(Animal.class))).thenReturn(mockAnimal);
        when(service.findById(animalId)).thenReturn(mockAnimal);

        var requestBody = AnimalDto.builder()
                .status(Animal.Status.ADOPTED)
                .build();

        var response = animalApi.update(requestBody, animalId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockAnimal.getStatus(), response.getBody().getStatus());
        assertEquals(animalId, response.getBody().getId());
        verify(service, atLeastOnce()).save(any(Animal.class));

    }
}
