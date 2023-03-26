package com.animals.challenge.dto;

import com.animals.challenge.model.BaseEntity;

public interface BaseDto<E extends BaseEntity> {

    void updateEntity(E entity);
}
