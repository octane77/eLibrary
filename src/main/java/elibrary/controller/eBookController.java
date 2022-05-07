package elibrary.controller;

import elibrary.dtos.eBook.requests.StoreEbookRequest;
import elibrary.dtos.eBook.responses.ApiResponse;
import elibrary.exceptions.Ebook.AuthorNotFoundException;
import elibrary.exceptions.Ebook.BookNotFoundException;
import elibrary.exceptions.Ebook.ElibraryException;
import elibrary.repository.EbookRepository;
import elibrary.services.Ebook.eBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/elibrary")
public class eBookController {
    @Autowired
    private eBookService elibrary;

    @GetMapping("/library")
    public EbookRepository getRepository() {
        return elibrary.getRepository();
    }

    @PostMapping("/saveEbook")
    public ResponseEntity<?> saveEbook(@RequestBody StoreEbookRequest request) {
        try {
            return new ResponseEntity<>(elibrary.storeEbook(request), HttpStatus.CREATED);
        } catch (ElibraryException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.FOUND);
        }
    }

    @GetMapping("/findByAuthor/{author}")
    public ResponseEntity<?> findEbookByAuthor(@PathVariable String author) {
        try {
            return new ResponseEntity<>(elibrary.findEbookByAuthor(author), HttpStatus.OK);
        } catch (AuthorNotFoundException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/findByTitle/{title}")
    public ResponseEntity<?> findEbookByTitle(@PathVariable String title) {
        try {
            return new ResponseEntity<>(elibrary.findEbookByTitle(title), HttpStatus.OK);
        } catch (BookNotFoundException exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
