package org.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Aliaksei.Kurbatau
 * @since 3/11/2023
 */
@FeignClient(name = "postServiceClient",
    url = "${social-network.discovery.post-service}/api/post-service/posts")
public interface PostServiceClient {

    @DeleteMapping("/all-for-user-id/{userId}")
    void deleteAllByUserId(@PathVariable Long userId);
}
