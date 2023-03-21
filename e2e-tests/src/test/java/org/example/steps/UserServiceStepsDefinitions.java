package org.example.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.example.dto.UserDto;

import java.util.Optional;

public class UserServiceStepsDefinitions extends AbstractStepsDefinitions {

    @Когда("анонимный пользователь пробует создать аккаунт в социальной сети с именем {string}")
    public void anonymousUserCreatesAUserAccountInSocialNetworkWithName(String name) {
        getContext().setUserName(name);
        UserDto dto = new UserDto();
        dto.setName(name);
        Optional<UserDto> userDtoOptional = userServiceClient.createNewUser(dto);
        if (userDtoOptional.isPresent()) {
            UserDto userDto = userDtoOptional.get();
            getContext().setUserId(userDto.getId());
            return;
        }
        System.out.println("User not created with name: " + name);
    }

    @Тогда("аккаунт не создан так как пользователю нет 18 лет")
    public void userAccountNotCreatedBecauseUserSAgeIsUnder() {
        String userName = getContext().getUserName();
        Optional<UserDto> userDtoOptional = userServiceClient.findUserByName(userName);
        if (userDtoOptional.isPresent()) {
            throw new RuntimeException("User should have not been created");
        }
    }

    @Тогда("аккаунт пользователя успешно создан в соцсети")
    public void userAccountSuccessfullyCreated() {
        Long userId = getContext().getUserId();
        Optional<UserDto> userDtoOptional = userServiceClient.findUserById(userId);
        if (userDtoOptional.isEmpty()) {
            throw new RuntimeException("User not created");
        }
    }

    @Когда("пользователь решает удалить свой аккаунт")
    public void userDecidesToDeleteTheirAccount() {
        Long userId = getContext().getUserId();
        userServiceClient.deleteUserAccount(userId);
    }

    @Тогда("в соцсети больше нет записи о пользователе")
    public void socialNetworkDoesNotHaveUserAccountAnyMore() {
        Long userId = getContext().getUserId();
        Optional<UserDto> userDtoOptional = userServiceClient.findUserById(userId);
        if (userDtoOptional.isPresent()) {
            throw new RuntimeException("User still exists");
        }
    }
}
