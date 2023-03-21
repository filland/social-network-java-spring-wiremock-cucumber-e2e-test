package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.awaitility.Awaitility;
import org.example.dto.PostDto;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Aliaksei.Kurbatau
 * @since 3/11/2023
 */
public class PostServiceStepsDefinitions extends AbstractStepsDefinitions {

    @When("user creates a post with content {string}")
    public void userCreatesAPostWithContent(String content) {
        Long userId = getContext().getUserId();
        PostDto postDto = new PostDto();
        postDto.setContent(content);
        postDto.setUserId(userId);
        postServiceClient.createNewPost(postDto);
    }

    @Then("user has one post")
    public void nowUserHasOnePost() {
        Long userId = getContext().getUserId();
        List<PostDto> list = postServiceClient.findAllByUserId(userId);
        if (list.size() != 1) {
            throw new RuntimeException("User should have 1 post but has: " + list.size());
        }
    }

    @Then("social network does not have posts for user any more")
    public void socialNetworkDoesNotHavePostsForUserAnyMore() {
        Long userId = getContext().getUserId();

        Awaitility.await()
                .atMost(10, TimeUnit.SECONDS)
                .pollInterval(2, TimeUnit.SECONDS)
                .until(() -> {
                    List<PostDto> list = postServiceClient.findAllByUserId(userId);

                    if (list.isEmpty()) {
                        return true;
                    }

                    System.out.println("User's posts still exist in social network");
                    return false;
                });
    }
}
