package elibrary.controller;

import elibrary.dtos.User.requests.DeleteUserRequestDto;
import elibrary.dtos.User.requests.RegisterUserRequestDto;
import elibrary.dtos.User.requests.UpdateUserRequestDto;
import elibrary.dtos.User.responses.APIResponse;
import elibrary.exceptions.User.ElibraryUserException;
import elibrary.exceptions.User.UserNotFoundException;
import elibrary.services.User.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/uauth")
public class UserController {

    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @PostMapping("/register")
    public ResponseEntity<?> createNewUserAccount(@RequestBody RegisterUserRequestDto registerUserRequestDto) {
        try {
            APIResponse response = APIResponse.builder()
                    .message("id: " + userServiceImplementation.registerUser(registerUserRequestDto))
                    .isSuccessful(true)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (ElibraryUserException exception) {
            APIResponse response = APIResponse.builder()
                    .message(exception.getMessage())
                    .isSuccessful(false)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/")
    public ResponseEntity<?> deleteUserAccount(@RequestBody DeleteUserRequestDto deleteUserRequestDto) {
        try {
            userServiceImplementation.deleteUser(deleteUserRequestDto);
            return new ResponseEntity<>(new APIResponse("User Deleted Successfully", true), HttpStatus.OK);

        } catch (UserNotFoundException exception) {
            APIResponse response = APIResponse.builder()
                    .message(exception.getMessage())
                    .isSuccessful(false)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("update/")
    public ResponseEntity<?> updateUserAccount(@RequestBody UpdateUserRequestDto updateUserRequestDto){
        try {
            userServiceImplementation.updateUser(updateUserRequestDto);
            return new ResponseEntity<>(new APIResponse("User Details Updated Successfully", true), HttpStatus.ACCEPTED);
        } catch (UserNotFoundException exception) {
            APIResponse response = APIResponse.builder()
                    .message(exception.getMessage())
                    .isSuccessful(false)
                    .build();
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}