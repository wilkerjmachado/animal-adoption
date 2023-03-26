package com.animals.challenge.integration.dto;

import com.animals.challenge.model.Animal;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseAnimalDto {

    private String id;

    private String name;

    @JsonAlias({"bred_for", "description"})
    private String description;

    private ResponseImageDto image;

    public Animal toAnimal(Animal.Category category) {
        return Animal.builder()
                .description(getDescription())
                .image(Objects.isNull(getImage()) ? null : getImage().getUrl())
                .name(getName())
                .integrationId(getId())
                .status(Animal.Status.AVAILABLE)
                .category(category)
                .build();
    }
}
