package com.animals.challenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Animal extends BaseEntity {

    public enum Status {
        ADOPTED, AVAILABLE;
    }

    public enum Category {
        CAT, DOG;
    }

    private String name;

    private String description;

    private String image;

    @Column(name = "integration_id")
    private String integrationId;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Status status;

}
