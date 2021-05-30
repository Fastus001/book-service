package pl.fastus.bookservice.exception;

/**
 * Created by Tom - 30.05.2021
 */
public class BookNotFoundByIdException extends RuntimeException{

    public BookNotFoundByIdException(String message) {
        super(message);
    }
}
