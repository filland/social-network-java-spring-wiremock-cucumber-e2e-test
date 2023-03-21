package org.example.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.awaitility.Awaitility;
import org.example.dto.PostDto;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PostServiceStepsDefinitions extends AbstractStepsDefinitions {

    @Когда("пользователь создает пост с текстом {string}")
    public void userCreatesAPostWithContent(String content) {
        Long userId = getContext().getUserId();
        PostDto postDto = new PostDto();
        postDto.setContent(content);
        postDto.setUserId(userId);
        postServiceClient.createNewPost(postDto);
    }

    @Тогда("у пользователя есть один пост")
    public void nowUserHasOnePost() {
        Long userId = getContext().getUserId();
        List<PostDto> list = postServiceClient.findAllByUserId(userId);
        if (list.size() != 1) {
            throw new RuntimeException("User should have 1 post but has: " + list.size());
        }
    }

    @Тогда("в соцсети больше нет постов пользователя")
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
