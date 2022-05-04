package elibrary.services.User;


import elibrary.dtos.User.requests.DeleteUserRequestDto;
import elibrary.dtos.User.requests.RegisterUserRequestDto;
import elibrary.dtos.User.requests.UpdateUserRequestDto;
import elibrary.dtos.User.responses.DeleteUserResponseDto;
import elibrary.dtos.User.responses.RegisterUserResponseDto;
import elibrary.dtos.User.responses.UpdateUserResponseDto;

public interface UserService {

    RegisterUserResponseDto registerUser(RegisterUserRequestDto registerUserRequest);
    DeleteUserResponseDto deleteUser(DeleteUserRequestDto deleteUserRequest);
    UpdateUserResponseDto updateUser(UpdateUserRequestDto updateUserRequest);
}
