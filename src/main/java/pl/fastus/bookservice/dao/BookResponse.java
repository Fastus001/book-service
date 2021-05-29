package pl.fastus.bookservice.dao;

import lombok.Data;
import pl.fastus.bookservice.domain.Author;

/**
 * Created by Tom - 29.05.2021
 */
@Data
public class BookResponse {

    private String isbn;
    private String title;
    private int numberOfPages;
    private Author author;
}
