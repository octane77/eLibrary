package elibrary.dtos.User.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class APIResponse {
    private String message;
    private Boolean isSuccessful;
}

