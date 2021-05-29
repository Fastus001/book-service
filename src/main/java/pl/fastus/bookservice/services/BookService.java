package pl.fastus.bookservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.fastus.bookservice.domain.Book;
import pl.fastus.bookservice.repository.BookRepository;

/**
 * Created by Tom - 29.05.2021
 */
@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository repository;

    public Book saveBook(Book book){
        return repository.save(book);
    }

    public Book getByIsbn(String isbn) {
        return repository.findBookByIsbn(isbn);
    }


}
