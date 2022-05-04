package elibrary.services.User;

import elibrary.dtos.User.requests.DeleteUserRequestDto;
import elibrary.dtos.User.requests.RegisterUserRequestDto;
import elibrary.dtos.User.requests.UpdateUserRequestDto;
import elibrary.dtos.User.responses.DeleteUserResponseDto;
import elibrary.dtos.User.responses.RegisterUserResponseDto;
import elibrary.dtos.User.responses.UpdateUserResponseDto;
import elibrary.exceptions.User.ElibraryUserException;
import elibrary.exceptions.User.UserNotFoundException;
import elibrary.models.User;
import elibrary.repository.UserRepository;
import elibrary.utils.UserModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponseDto registerUser(RegisterUserRequestDto registerUserRequest) {
        Optional<User> optionalUser = userRepository.findUserByEmail(registerUserRequest.getEmail());
        if (optionalUser.isPresent()) {
            throw new ElibraryUserException("This email address is already taken, please use another");
        }
        User user = UserModelMapper.registerUserMap(registerUserRequest);
        User saveUser = userRepository.save(user);
        return UserModelMapper.registerUserMap(saveUser);
    }

    @Override
    public DeleteUserResponseDto deleteUser(DeleteUserRequestDto deleteUserRequest) {
        Optional<User> optionalUser = userRepository.findUserByEmail(deleteUserRequest.getEmail());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("This User Doesn't Exist");
        }

        optionalUser = userRepository.findUserByUsername(deleteUserRequest.getUsername());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("This User Doesn't Exist");
        }

        User userToDelete = optionalUser.get();
        userRepository.delete(userToDelete);

        DeleteUserResponseDto response = new DeleteUserResponseDto();
        response.setMessage("User Deleted Successfully");
        return response;
    }

    @Override
    public UpdateUserResponseDto updateUser(UpdateUserRequestDto updateUserRequest) {
        Optional<User> optionalUser = userRepository.findUserByEmail(updateUserRequest.getEmail());
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("This User Doesn't Exist");
        }
        User user = UserModelMapper.updateUserMap(updateUserRequest);
        User updatedUser = userRepository.save(user);
        return UserModelMapper.updateUserMap(updatedUser);
    }


}