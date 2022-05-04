package elibrary.services.Ebook;

import elibrary.dtos.eBook.requests.FindEbookByTitleRequest;
import elibrary.dtos.eBook.requests.StoreEbookRequest;
import elibrary.dtos.eBook.responses.FindEbookByAuthorResponse;
import elibrary.dtos.eBook.responses.FindEbookByTitleResponse;
import elibrary.dtos.eBook.responses.StoreEbookResponse;
import elibrary.repository.EbookRepository;

import java.util.List;

public interface eBookService {
    EbookRepository getRepository();
    StoreEbookResponse storeEbook(StoreEbookRequest request);
    FindEbookByTitleResponse findEbookByTitle(FindEbookByTitleRequest request);
    List<FindEbookByAuthorResponse> findEbookByAuthor(String author);


}
