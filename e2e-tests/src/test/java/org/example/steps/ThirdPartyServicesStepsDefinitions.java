package org.example.steps;

import com.github.tomakehurst.wiremock.matching.EqualToPattern;
import io.cucumber.java.en.Given;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;

public class ThirdPartyServicesStepsDefinitions extends AbstractStepsDefinitions {

    @Given("Age API will not confirm that user with name {string} is adult")
    public void ageAPIDoesNotConfirmThatUserWithNameIsAdult(String name) {
        mockAgeApi(name, false);
    }

    @Given("Age API will confirm that user with name {string} is adult")
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

    @Given("Word API will not find swearing words in post")
    public void wordAPIConfirmsThatPostDoesNotHaveSwearingWords() {
        mockWordApi(false);
    }

    @Given("Word API will find swearing words in post")
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
