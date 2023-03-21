package org.example.common.client;

import org.example.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "userServiceClient",
        url = "${social-network.discovery.user-service}/api/user-service/users")
public interface UserServiceClient {

    @PostMapping
    Optional<UserDto> createNewUser(@RequestBody UserDto userDto);

    @GetMapping("/{userId}")
    Optional<UserDto> findUserById(@PathVariable Long userId);

    @GetMapping("/find-by-name")
    Optional<UserDto> findUserByName(@RequestParam String name);

    @DeleteMapping("/{userId}")
    void deleteUserAccount(@PathVariable Long userId);

}
