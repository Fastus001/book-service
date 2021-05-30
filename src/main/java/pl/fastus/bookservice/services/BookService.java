package pl.fastus.bookservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.fastus.bookservice.domain.Author;
import pl.fastus.bookservice.domain.Book;
import pl.fastus.bookservice.exception.BookNotFoundByIdException;
import pl.fastus.bookservice.exception.BookNotFoundByIsbnException;
import pl.fastus.bookservice.repository.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

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
        return repository.findByIsbn(isbn)
                .orElseThrow(()->new BookNotFoundByIsbnException(isbn));
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public List<Long> findByAuthor(Author author) {
        return repository.findAllByAuthor(author)
                    .stream()
                    .map(Book::getId)
                    .collect(Collectors.toList());
    }

    public Book getById(Long id) {
        return repository.findById(id).orElseThrow(()-> new BookNotFoundByIdException(Long.toString(id)));
    }
}
