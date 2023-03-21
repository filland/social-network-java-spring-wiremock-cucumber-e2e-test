package org.example.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Aliaksei.Kurbatau
 * @since 12/26/2022
 */
@Component
@AllArgsConstructor
public class JsonHelper {

    private final ObjectMapper objectMapper;

    public <T> String fromObjectToString(T object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
