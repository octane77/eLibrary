package repository;

import models.Ebook;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EbookRepository extends MongoRepository<Ebook, String>{
        Ebook findEbookByTitle(String title);
        Ebook findEbookByAuthor(String author);
        Ebook findEbookByNumberOfPages(String numberOfPages);
        Ebook findEbookByGenre(String Genre);
        Ebook findEbookByISBNMatches(String ISBN);
        Ebook findEbookByDescription(String description);
}
