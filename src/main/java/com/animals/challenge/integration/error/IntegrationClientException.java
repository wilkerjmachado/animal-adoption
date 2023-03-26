package com.animals.challenge.integration.error;

import lombok.Getter;

@Getter
public class IntegrationClientException extends RuntimeException {

    private Integer statusCode;

    public IntegrationClientException(String message, Integer statusCode) {

        super(message);

        this.statusCode = statusCode;
    }

}
