package elibrary.dtos.User.requests;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@NonNull
@ToString
public class RegisterUserRequestDto {
    @Id
    private Long id;
    @Size(max = 20)
    private String username;
    @Email
    @Size(max = 50)
    private String email;
    @Size(max = 120)
    private String password;
}
