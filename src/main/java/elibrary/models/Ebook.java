package elibrary.models;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

@Data
@NonNull
@Document("eBook")
public class Ebook {
    @Id
    private String id;
    @Size(max = 50)
    private String author;
    @Size(max = 50)
    private String publisher;
    @Size(max = 20)
    private String ISBN;
    @Size(max = 50)
    private String title;
    private int numberOfPages;
    private String description;
    @Size(max = 50)
    private String genre;
    @DBRef
    private User loggedInUser;
}
