package org.example.dto;

import lombok.Data;

@Data
public class PostDto {
    private Long id;
    private Long userId;
    private String content;
}
