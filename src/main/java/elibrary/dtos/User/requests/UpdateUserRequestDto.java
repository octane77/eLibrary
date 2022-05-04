package elibrary.dtos.User.requests;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
@Builder
public class UpdateUserRequestDto {
    private String id;
    @Email
    private String email;
    private String password;
}
