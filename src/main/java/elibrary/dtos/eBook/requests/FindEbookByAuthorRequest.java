package elibrary.dtos.eBook.requests;

import lombok.Data;

@Data
public class FindEbookByAuthorRequest {
    private String Author;
}
