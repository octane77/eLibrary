package dtos.requests;

import lombok.Data;

@Data
public class StoreEbookRequest {
    private String title;
    private String author;
    private String ISBN;
    private int numberOfPages;
    private String genre;
    private String description;
}
