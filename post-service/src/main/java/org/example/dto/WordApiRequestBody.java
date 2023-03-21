package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Aliaksei.Kurbatau
 * @since 3/11/2023
 */
@Data
@AllArgsConstructor
public class WordApiRequestBody {
    private String text;
}
