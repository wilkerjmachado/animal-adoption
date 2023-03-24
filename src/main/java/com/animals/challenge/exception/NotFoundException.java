package com.animals.challenge.exception;

import java.util.Objects;

public class NotFoundException extends ServiceException{

    private static final String MSG_ERROR_ENTITY_NOT_FOUND = "No records found!";

    public NotFoundException(String message) {

        super(Objects.isNull(message) ? MSG_ERROR_ENTITY_NOT_FOUND: message);
    }

    public NotFoundException() {

        super(MSG_ERROR_ENTITY_NOT_FOUND);
    }
}
