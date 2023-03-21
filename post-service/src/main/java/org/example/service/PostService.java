package org.example.service;

import org.example.dto.PostDto;
import org.example.model.Post;
import org.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Aliaksei.Kurbatau
 * @since 3/11/2023
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private WordApiService wordApiService;

    public Optional<PostDto> createNewPost(PostDto postDto) {

        if (wordApiService.hasBadWords(postDto.getContent())) {
            return Optional.empty();
        }

        Post post = new Post();
        post.setUserId(postDto.getUserId());
        post.setContent(postDto.getContent());
        post.setCreated(LocalDateTime.now());
        post.setUpdated(LocalDateTime.now());
        Post savedPost = postRepository.save(post);
        postDto.setId(savedPost.getId());
        return Optional.of(postDto);
    }

    public PostDto findPost(Long postId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new RuntimeException("post with id not found: " + postId));
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setUserId(post.getUserId());
        dto.setContent(post.getContent());
        return dto;
    }

    @Transactional
    public void deleteAllByUserId(Long userId) {
        postRepository.deleteAllByUserId(userId);
    }

    public List<PostDto> findAllByUserId(Long userId) {
        List<Post> list = postRepository.findAllByUserId(userId);
        return list.stream().map(post -> {
            PostDto dto = new PostDto();
            dto.setId(post.getId());
            dto.setUserId(post.getUserId());
            dto.setContent(post.getContent());
            return dto;
        }).collect(Collectors.toList());
    }
}
