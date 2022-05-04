package elibrary.exceptions.User;

public class UserNotFoundException extends ElibraryUserException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
