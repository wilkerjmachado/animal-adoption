package com.animals.challenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Partner extends BaseEntity{

    private String name;

    private String url;

    @Column(name = "api_key")
    private String apiKey;
}
