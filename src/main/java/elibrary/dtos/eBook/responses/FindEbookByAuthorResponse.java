package elibrary.dtos.eBook.responses;

import lombok.Data;

@Data
public class FindEbookByAuthorResponse {
    private String Author;
    private String Message;
}
