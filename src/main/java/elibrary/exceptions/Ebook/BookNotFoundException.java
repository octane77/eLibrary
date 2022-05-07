package elibrary.exceptions.Ebook;

public class BookNotFoundException extends ElibraryException {
    public BookNotFoundException(String message) {
        super(message);
    }
}