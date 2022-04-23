package elibrary.models;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@NonNull
@Data
@ToString
@Document(collection = "User")
public class User {
    @Size(max = 50)
    @Email
    private String email;
    @Size(max = 20)
    private String username;
    @Size(max = 120)
    private String password;
}
