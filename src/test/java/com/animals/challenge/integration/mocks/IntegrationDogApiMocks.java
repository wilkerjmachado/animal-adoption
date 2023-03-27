package com.animals.challenge.integration.mocks;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class IntegrationDogApiMocks {

    public static void setupMockBreedsResponse(WireMockServer mockService) throws IOException {
        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/breeds"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(
                                StreamUtils.copyToString(
                                        IntegrationDogApiMocks.class.getClassLoader().getResourceAsStream("payload/response_dogs.json"),
                                        StandardCharsets.UTF_8))));
    }

}
