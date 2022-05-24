package elibrary.services.Ebook;

import elibrary.dtos.eBook.requests.StoreEbookRequest;
import elibrary.dtos.eBook.responses.FindEbookByAuthorResponse;
import elibrary.dtos.eBook.responses.FindEbookByTitleResponse;
import elibrary.dtos.eBook.responses.StoreEbookResponse;
import elibrary.exceptions.Ebook.AuthorNotFoundException;
import elibrary.exceptions.Ebook.BookNotFoundException;
import elibrary.models.Ebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import elibrary.repository.EbookRepository;
import elibrary.utils.EbookModelMapper;

import java.util.ArrayList;
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
    public List<FindEbookByTitleResponse> findEbookByTitle(String title) {
        List<Ebook> ebooks = new ArrayList<>(library.findEbookByTitle(title));
        if(ebooks.isEmpty()) throw new BookNotFoundException("There are no books matching this title in this Library");
        List<FindEbookByTitleResponse> response = new ArrayList<>();
        ebooks.forEach(ebook -> response.add(new FindEbookByTitleResponse(ebook)));
        return response;
    }


    @Override
    public List<FindEbookByAuthorResponse> findEbookByAuthor(String author) {
        List<Ebook> ebooks = new ArrayList<>(library.findEbookByAuthor(author));
        if(ebooks.isEmpty()) throw new AuthorNotFoundException("We were unable to find any books in this Library written by this Author");
        List<FindEbookByAuthorResponse> response = new ArrayList<>();
        ebooks.forEach(ebook -> response.add(new FindEbookByAuthorResponse(ebook)));
        return response;
    }

    @Override
    public List<EbookRepository> getRepository() {
        return null;
    }


}
