package models;

import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NonNull
@Document("eBook")
public class Ebook {
    @Id
    private String id;
    private String author;
    private String publisher;
    private String ISBN;
    private String title;
    private String numberOfPages;
    private String description;
    private String genre;
}
