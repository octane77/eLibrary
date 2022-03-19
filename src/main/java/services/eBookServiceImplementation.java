package services;

import dtos.requests.StoreEbookRequest;
import dtos.responses.StoreEbookResponse;
import models.Ebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import repository.EbookRepository;
import utils.ModelMapper;

@Service
public class eBookServiceImplementation implements eBookService {
    @Autowired
    private EbookRepository library;

    @Override
    public StoreEbookResponse storeEbook(StoreEbookRequest request) {
        Ebook eBook = ModelMapper.map(request);
        Ebook saveEbook = library.save(eBook);
        return ModelMapper.map(saveEbook);
    }

    @Override
    public EbookRepository getRepository() {
        return null;
    }


}
