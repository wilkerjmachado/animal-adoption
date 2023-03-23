package com.animals.challenge.model;

import jakarta.persistence.*;

@Entity
public class Animal extends BaseEntity{

    public enum Status{
        ADOPTED, AVAILABLE;
    }

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private AnimalType type;

    private String name;

    private String description;

    private String image;

    @Enumerated(EnumType.STRING)
    private Status status;

}
