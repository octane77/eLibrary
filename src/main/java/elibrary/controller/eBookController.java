package elibrary.controller;

import elibrary.dtos.eBook.requests.StoreEbookRequest;
import elibrary.dtos.eBook.responses.ApiResponse;
import elibrary.repository.EbookRepository;
import elibrary.services.eBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/elibrary")
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
        } catch (RuntimeException e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.FOUND);
        }
    }

//    @PostMapping ("/registeruser")
//    public ResponseEntity<?> registeruser(@RequestBody )

    @GetMapping("/findByAuthor/{keyword}")
    public ResponseEntity<?> findEbookByAuthor(@PathVariable String keyword) {
        try {
            return new ResponseEntity<>(elibrary.findEbookByAuthor(keyword), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new ApiResponse(false, ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

}
