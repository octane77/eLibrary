package elibrary.services.Ebook;

import elibrary.dtos.eBook.requests.FindEbookByTitleRequest;
import elibrary.dtos.eBook.requests.StoreEbookRequest;
import elibrary.dtos.eBook.responses.FindEbookByAuthorResponse;
import elibrary.dtos.eBook.responses.FindEbookByTitleResponse;
import elibrary.dtos.eBook.responses.StoreEbookResponse;
import elibrary.models.Ebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import elibrary.repository.EbookRepository;
import elibrary.utils.EbookModelMapper;

import java.util.List;

@Service
public class eBookServiceImplementation implements eBookService {
    @Autowired
    private EbookRepository library;

    @Override
    public StoreEbookResponse storeEbook(StoreEbookRequest request) {
        Ebook eBook = EbookModelMapper.map(request);
        Ebook saveEbook = library.save(eBook);
        return EbookModelMapper.map(saveEbook);
    }

    @Override
    public FindEbookByTitleResponse findEbookByTitle(FindEbookByTitleRequest request) {
        return null;
    }

    @Override
    public List<FindEbookByAuthorResponse> findEbookByAuthor(String author) {
//        List<Ebook> eBook = ;
        return null;
    }

    @Override
    public EbookRepository getRepository() {
        return library;
    }


}
