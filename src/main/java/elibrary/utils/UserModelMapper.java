package elibrary.utils;

import elibrary.dtos.User.requests.RegisterUserRequestDto;
import elibrary.dtos.User.requests.UpdateUserRequestDto;
import elibrary.dtos.User.responses.RegisterUserResponseDto;
import elibrary.dtos.User.responses.UpdateUserResponseDto;
import elibrary.models.User;

public class UserModelMapper {
    public static User registerUserMap(RegisterUserRequestDto request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return user;
    }

    public static RegisterUserResponseDto registerUserMap(User user) {
        RegisterUserResponseDto response = new RegisterUserResponseDto();
        response.setDetails("Welcome to the eLibrary! " + user.getUsername());
        response.setMessage("An account confirmation email has been sent to " + user.getEmail());
        return response;
    }

    public static User updateUserMap(UpdateUserRequestDto request) {
        User user = new User();
        boolean isUpdated = false;
        if (!(request.getEmail() == null || request.getEmail().trim().equals(""))) {
            user.setEmail(request.getEmail());
            isUpdated = true;
        }
        if (!(request.getPassword() == null || request.getPassword().trim().equals(""))) {
            user.setPassword(request.getPassword());
            isUpdated = true;
        }
        if (isUpdated) {
            return user;
        }
        return null;
    }

    public static UpdateUserResponseDto updateUserMap(User user){
        UpdateUserResponseDto response = new UpdateUserResponseDto();
        response.setMessage("User details for  " + user.getUsername() + " have been changed successfully");
        return response;
    }
}