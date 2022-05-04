package elibrary.utils;

import elibrary.dtos.eBook.requests.StoreEbookRequest;
import elibrary.dtos.eBook.responses.StoreEbookResponse;
import elibrary.models.Ebook;

public class EbookModelMapper {

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
        response.setDetails(ebook.getTitle() + " by " + ebook.getAuthor());
        response.setMessage(ebook.getTitle() + " by " + ebook.getAuthor() + " has been successfully added to the library");
        return response;
    }

}