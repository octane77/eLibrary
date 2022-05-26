package elibrary.dtos.eBook.responses;

import elibrary.models.Ebook;
import lombok.Data;

@Data
public class FindEbookByAuthorResponse {
    private String author;
    private String title;
    private String description;
    private String genre;

    public FindEbookByAuthorResponse(Ebook ebook) {
        author = ebook.getAuthor();
        title = ebook.getTitle();
        description = ebook.getDescription();
        genre = ebook.getGenre();
    }
}
