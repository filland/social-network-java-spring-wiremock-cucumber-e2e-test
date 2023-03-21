package org.example.dto;

import lombok.Data;

/**
 * @author Aliaksei.Kurbatau
 * @since 3/11/2023
 */
@Data
public class PostDto {
    private Long id;
    private Long userId;
    private String content;
}
