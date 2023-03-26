package com.animals.challenge.integration.error;

public class NotFoundException extends IntegrationClientException {

    public NotFoundException(String message, Integer statusCode) {

        super(message, statusCode);
    }

}
