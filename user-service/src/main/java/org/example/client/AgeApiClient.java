package org.example.client;

import org.example.dto.AgeApiRequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ageApiClient", url = "${social-network.age-api-url}")
public interface AgeApiClient {

    @PostMapping("/is-person-adult")
    boolean isPersonAdult(@RequestBody AgeApiRequestBody body);
}
