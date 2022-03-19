package controller;

import dtos.requests.StoreEbookRequest;
import dtos.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.EbookRepository;
import services.eBookService;

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
}
