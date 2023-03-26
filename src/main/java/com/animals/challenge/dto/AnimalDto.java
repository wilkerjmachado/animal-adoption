package com.animals.challenge.dto;

import com.animals.challenge.model.Animal;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnimalDto implements BaseDto<Animal> {

    private Animal.Status status;

    private Animal.Category category;

    @JsonProperty("created_at")
    private LocalDate createdAt;

    @Override
    public void updateEntity(Animal entity) {

        entity.setStatus(this.status);
    }
}
