package org.example.controller;

import org.example.dto.PostDto;
import org.example.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/post-service/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public Optional<PostDto> createNewPost(@RequestBody PostDto postDto) {
        return postService.createNewPost(postDto);
    }

    @GetMapping("/{postId}")
    public PostDto findPost(@PathVariable Long postId) {
        return postService.findPost(postId);
    }

    @GetMapping("/find-all-by-user-id/{userId}")
    public List<PostDto> findAllByUserId(@PathVariable Long userId) {
        return postService.findAllByUserId(userId);
    }

    @DeleteMapping("/all-for-user-id/{userId}")
    void deleteAllByUserId(@PathVariable Long userId) {
        postService.deleteAllByUserId(userId);
    }

}
