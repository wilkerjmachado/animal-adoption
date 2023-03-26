package com.animals.challenge.integration.client;

import com.animals.challenge.integration.dto.ResponseAnimalDto;
import com.animals.challenge.integration.config.FeignClientConfig;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Headers("x-api-key: ${app.integration.api.cat.key}")
@FeignClient(
        name = "${app.integration.api.cat.name}", url = "${app.integration.api.cat.url}",
        configuration = FeignClientConfig.class)
public interface IntegrationCatClient {

    @GetMapping(value = "breeds")
    List<ResponseAnimalDto> getBreads(@RequestHeader("x-api-key") String key);

}