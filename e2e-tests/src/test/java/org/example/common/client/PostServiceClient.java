package org.example.common.client;

import org.example.dto.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "postServiceClient",
        url = "${social-network.discovery.post-service}/api/post-service/posts")
public interface PostServiceClient {

    @PostMapping
    Optional<PostDto> createNewPost(@RequestBody PostDto postDto);

    @GetMapping("/find-all-by-user-id/{userId}")
    List<PostDto> findAllByUserId(@PathVariable Long userId);
}
