package org.example.service;

import org.example.client.PostServiceClient;
import org.example.dto.UserDto;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Aliaksei.Kurbatau
 * @since 3/11/2023
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AgeApiService ageApiService;

    @Autowired
    private PostServiceClient postServiceClient;

    public Optional<UserDto> createNewUser(UserDto userDto) {

        if (!ageApiService.hasAllowedAge(userDto.getName())) {
            return Optional.empty();
        }

        User user = new User();
        user.setName(userDto.getName());
        User savedUser = userRepository.save(user);
        userDto.setId(savedUser.getId());
        return Optional.of(userDto);
    }

    public Optional<UserDto> findUserByName(String name) {
        Optional<User> optional = userRepository.findByName(name);
        if (optional.isEmpty()) {
            return Optional.empty();
        }
        User user = optional.get();
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        return Optional.of(dto);
    }

    public Optional<UserDto> findUserById(Long userId) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isEmpty()) {
            return Optional.empty();
        }
        User user = optional.get();
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        return Optional.of(dto);
    }

    public void deleteUserAccount(Long userId) {

        try {
            Thread.sleep(4_000);
        } catch (InterruptedException ignored) {
        }

        postServiceClient.deleteAllByUserId(userId);
        userRepository.deleteById(userId);
    }
}
