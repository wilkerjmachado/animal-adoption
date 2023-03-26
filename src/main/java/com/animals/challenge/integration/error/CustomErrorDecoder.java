package com.animals.challenge.integration.error;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 400 -> new IntegrationClientException(response.reason(), response.status());
            case 404 -> new NotFoundException(response.reason(), response.status());
            default -> new IntegrationClientException("Error to get data from api: " + response.reason(), response.status());
        };
    }
}
