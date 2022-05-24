package elibrary.services.Ebook;

import elibrary.dtos.eBook.requests.StoreEbookRequest;
import elibrary.dtos.eBook.responses.FindEbookByAuthorResponse;
import elibrary.dtos.eBook.responses.FindEbookByTitleResponse;
import elibrary.dtos.eBook.responses.StoreEbookResponse;
import elibrary.repository.EbookRepository;

import java.util.List;

public interface eBookService {
    List<EbookRepository> getRepository();
    StoreEbookResponse storeEbook(StoreEbookRequest request);
    List<FindEbookByTitleResponse> findEbookByTitle(String title);
    List<FindEbookByAuthorResponse> findEbookByAuthor(String author);


}
