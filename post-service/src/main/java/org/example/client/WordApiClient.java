package org.example.client;

import org.example.dto.WordApiRequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "wordApiClient", url = "${social-network.word-api-url}")
public interface WordApiClient {

    @PostMapping("/has-swearing-words")
    boolean textHasSwearingWords(@RequestBody WordApiRequestBody body);
}
