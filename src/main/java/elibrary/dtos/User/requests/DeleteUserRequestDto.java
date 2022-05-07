package elibrary.dtos.User.requests;

import elibrary.models.User;
import lombok.Builder;
import lombok.Data;

@Data
public class DeleteUserRequestDto {
    private String email;
}
