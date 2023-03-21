package org.example.controller;

import org.example.dto.UserDto;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Aliaksei.Kurbatau
 * @since 3/11/2023
 */
@RestController
@RequestMapping("/api/user-service/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Optional<UserDto> createNewUser(@RequestBody UserDto userDto) {
        return userService.createNewUser(userDto);
    }

    @GetMapping("/{userId}")
    public Optional<UserDto> findUserId(@PathVariable Long userId) {
        return userService.findUserById(userId);
    }

    @GetMapping("/find-by-name")
    public Optional<UserDto> findUserByName(@RequestParam String name) {
        return userService.findUserByName(name);
    }

    @Async
    @DeleteMapping("/{userId}")
    public void deleteUserAccount(@PathVariable Long userId) {
        userService.deleteUserAccount(userId);
    }

}
