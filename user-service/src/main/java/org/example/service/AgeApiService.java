package org.example.service;

import org.example.client.AgeApiClient;
import org.example.dto.AgeApiRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgeApiService {

    @Autowired
    private AgeApiClient ageApiClient;

    /**
     * @param name name of user
     * @return true if user is 18 years old or older, otherwise - false
     */
    public boolean hasAllowedAge(String name) {
        return ageApiClient.isPersonAdult(new AgeApiRequestBody(name));
    }

}
