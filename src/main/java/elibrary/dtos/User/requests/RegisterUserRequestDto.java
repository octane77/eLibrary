package elibrary.dtos.User.requests;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class RegisterUserRequestDto {
    @Size(max = 20)
    private String username;
    @Email
    @Size(max = 50)
    private String email;
    @Size(max = 120)
    private String password;
}
