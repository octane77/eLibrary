package elibrary.models;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Set;

@NonNull
@Data
@Document(collection = "User")
public class User {
    @Id
    private String id;
    @Size(max = 50)
    @Email
    @UniqueElements
    private String email;
    @Size(max = 20)
    @UniqueElements
    private String username;
    @Size(max = 120)
    private String password;
    @DBRef
    private Set<Ebook> eBookLibrary;
}
