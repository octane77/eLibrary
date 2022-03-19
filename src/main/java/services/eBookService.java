package services;

import dtos.requests.StoreEbookRequest;
import dtos.responses.StoreEbookResponse;
import repository.EbookRepository;

public interface eBookService {
    StoreEbookResponse storeEbook(StoreEbookRequest request);
    EbookRepository getRepository();
}
