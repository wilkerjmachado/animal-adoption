package com.animals.challenge.api;

import com.animals.challenge.model.Animal;
import com.animals.challenge.service.AnimalService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;

@Getter
@AllArgsConstructor
@Controller("animal")
public class AnimalApi extends BaseApi<Animal, AnimalService>{

    private AnimalService service;
}
