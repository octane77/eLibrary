package elibrary.dtos.eBook.responses;

import elibrary.models.Ebook;
import lombok.Data;

@Data
public class FindEbookByTitleResponse {
    private String author;
    private String publisher;
    private String ISBN;
    private String title;
    private int numberOfPages;
    private String description;
    private String genre;


    public FindEbookByTitleResponse(Ebook ebook) {
        author = ebook.getAuthor();
        publisher = ebook.getPublisher();
        ISBN = ebook.getISBN();
        title = ebook.getTitle();
        numberOfPages = ebook.getNumberOfPages();
        description = ebook.getDescription();
        genre = ebook.getGenre();
    }
}
