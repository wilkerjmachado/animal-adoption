package com.animals.challenge.api;

import com.animals.challenge.dto.AnimalDto;
import com.animals.challenge.integration.service.IntegrationService;
import com.animals.challenge.model.Animal;
import com.animals.challenge.service.AnimalService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Getter
@AllArgsConstructor
@Controller("animal")
public class AnimalApi extends BaseApi<Animal, AnimalDto, AnimalService> {

    private AnimalService service;

    private IntegrationService integrationService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/integration/index")
    public ResponseEntity<?> index() {

        this.integrationService.index();

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}
