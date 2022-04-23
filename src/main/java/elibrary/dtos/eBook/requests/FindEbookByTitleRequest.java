package elibrary.dtos.eBook.requests;

import lombok.Data;

@Data
public class FindEbookByTitleRequest {
    private String Title;
}
