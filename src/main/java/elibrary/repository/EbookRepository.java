package elibrary.repository;

import elibrary.models.Ebook;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EbookRepository extends MongoRepository<Ebook, String> {
    List <Ebook> findEbookByTitle(String title);

    List<Ebook> findEbookByAuthor(String author);

    Ebook findEbookByNumberOfPages(String numberOfPages);

    Ebook findEbookByGenre(String Genre);

    Ebook findEbookByISBNMatches(String ISBN);

    Ebook findEbookByDescription(String description);
}
