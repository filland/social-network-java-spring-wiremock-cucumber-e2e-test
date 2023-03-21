package org.example.service;

import org.example.client.WordApiClient;
import org.example.dto.WordApiRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordApiService {

    @Autowired
    private WordApiClient wordApiClient;

    /**
     * Check if the provided text contains swearing words
     *
     * @param text content of post
     * @return true if provided content has swearing words, otherwise - false
     */
    public boolean hasBadWords(String text) {
        return wordApiClient.textHasSwearingWords(new WordApiRequestBody(text));
    }

}
