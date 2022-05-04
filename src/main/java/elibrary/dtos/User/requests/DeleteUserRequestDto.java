package elibrary.dtos.User.requests;

import elibrary.models.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteUserRequestDto {
    private String username;
    private String email;
    private User deleteUserRequest;
}
