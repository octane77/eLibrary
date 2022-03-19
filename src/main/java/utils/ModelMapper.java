package utils;

import dtos.requests.StoreEbookRequest;
import dtos.responses.StoreEbookResponse;
import models.Ebook;

public class ModelMapper {

    public static Ebook map(StoreEbookRequest request) {
    Ebook ebook = new Ebook();
    ebook.setAuthor(request.getAuthor());
    ebook.setDescription(request.getDescription());
    ebook.setISBN(request.getISBN());
    ebook.setGenre(request.getGenre());
    ebook.setTitle(request.getTitle());
    ebook.setPublisher(ebook.getPublisher());
    ebook.setNumberOfPages(ebook.getNumberOfPages());
    return ebook;
    }


    public static StoreEbookResponse map(Ebook ebook) {
        StoreEbookResponse response = new StoreEbookResponse();
        response.setDetails(ebook.getTitle()+" by "+ebook.getAuthor()+"\n"+ebook.getGenre());
        response.setMessage("Ebook has been successfully added to the library");
        return response;
    }
}
