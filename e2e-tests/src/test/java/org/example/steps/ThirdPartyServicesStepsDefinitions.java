package org.example.steps;

import com.github.tomakehurst.wiremock.matching.EqualToPattern;
import io.cucumber.java.ru.Дано;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;

public class ThirdPartyServicesStepsDefinitions extends AbstractStepsDefinitions {

    @Дано("Age API не подтвердит что человек с именем {string} совершеннолетний")
    public void ageAPIDoesNotConfirmThatUserWithNameIsAdult(String name) {
        mockAgeApi(name, false);
    }

    @Дано("Age API подтвердит что человек с именем {string} совершеннолетний")
    public void ageAPIConfirmsThatUserWithNameIsAdult(String name) {
        mockAgeApi(name, true);
    }

    private void mockAgeApi(String name, boolean responseFromApi) {
        String requestBody = "{\"name\":\"" + name + "\"}";
        wiremockServer.stubFor(post("/is-person-adult")
                .withRequestBody(new EqualToPattern(requestBody))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(jsonHelper.fromObjectToString(responseFromApi))
                )
        );
    }

    @Дано("Word API не найдет матных слов в посте")
    public void wordAPIConfirmsThatPostDoesNotHaveSwearingWords() {
        mockWordApi(false);
    }

    @Дано("Word API найдет матные слов в посте")
    public void wordAPIFindsSwearingWordsInPost() {
        mockWordApi(true);
    }

    private void mockWordApi(boolean responseFromApi) {
        wiremockServer.stubFor(post("/has-swearing-words")
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(jsonHelper.fromObjectToString(responseFromApi))
                )
        );
    }
}
