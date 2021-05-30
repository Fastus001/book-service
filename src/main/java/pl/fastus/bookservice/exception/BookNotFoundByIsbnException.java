package pl.fastus.bookservice.exception;

/**
 * Created by Tom - 30.05.2021
 */
public class BookNotFoundByIsbnException extends RuntimeException{

    public BookNotFoundByIsbnException(String message) {
        super(message);
    }
}
