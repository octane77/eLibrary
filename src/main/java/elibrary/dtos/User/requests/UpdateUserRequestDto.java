package elibrary.dtos.User.requests;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class UpdateUserRequestDto {
    @Size(max = 20)
    private String username;
    @Email
    @Size(max = 50)
    private String email;
    @Size(max = 120)
    private String password;
}
