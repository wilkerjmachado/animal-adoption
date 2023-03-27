package com.animals.challenge.integration;

import com.animals.challenge.integration.client.IntegrationDogClient;
import com.animals.challenge.integration.config.WireMockConfig;
import com.animals.challenge.integration.mocks.IntegrationDogApiMocks;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {WireMockConfig.class})
public class IntegrationDogApiTests {

    public static final String KEY = "";

    private static WireMockServer wireMockServer;

    @BeforeAll
    static void init() {
        wireMockServer = new WireMockServer(
                new WireMockConfiguration().port(9561)
        );
        wireMockServer.start();
        WireMock.configureFor("localhost", 9561);
    }

    @AfterAll
    static void destroy() {
        wireMockServer.stop();
    }


    @Autowired
    private IntegrationDogClient integrationDogClient;

    @BeforeEach
    void setUp() throws IOException {
        IntegrationDogApiMocks.setupMockBreedsResponse(wireMockServer);
    }

    @Test
    public void whenGetDogs_thenDogsShouldBeReturned() {
        Assertions.assertFalse(integrationDogClient.getBreads(KEY).isEmpty());
    }


    @Test
    public void whenGetDogs_thenTheCorrectDogsShouldBeReturned() {
        Assertions.assertFalse(integrationDogClient.getBreads(KEY)
                .stream()
                .filter(response -> response.getName().equals("Affenpinscher"))
                .toList().isEmpty());
    }
}
