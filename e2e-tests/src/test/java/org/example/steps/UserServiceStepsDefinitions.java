package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.dto.UserDto;

import java.util.Optional;

public class UserServiceStepsDefinitions extends AbstractStepsDefinitions {

    @When("anonymous user creates a user account in social network with name {string}")
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

    @Then("user account not created because user's age is under 18")
    public void userAccountNotCreatedBecauseUserSAgeIsUnder() {
        String userName = getContext().getUserName();
        Optional<UserDto> userDtoOptional = userServiceClient.findUserByName(userName);
        if (userDtoOptional.isPresent()) {
            throw new RuntimeException("User should have not been created");
        }
    }

    @Then("user account successfully created")
    public void userAccountSuccessfullyCreated() {
        Long userId = getContext().getUserId();
        Optional<UserDto> userDtoOptional = userServiceClient.findUserById(userId);
        if (userDtoOptional.isEmpty()) {
            throw new RuntimeException("User not created");
        }
    }

    @When("user decides to delete their account")
    public void userDecidesToDeleteTheirAccount() {
        Long userId = getContext().getUserId();
        userServiceClient.deleteUserAccount(userId);
    }

    @Then("social network does not have user account any more")
    public void socialNetworkDoesNotHaveUserAccountAnyMore() {
        Long userId = getContext().getUserId();
        Optional<UserDto> userDtoOptional = userServiceClient.findUserById(userId);
        if (userDtoOptional.isPresent()) {
            throw new RuntimeException("User still exists");
        }
    }
}
