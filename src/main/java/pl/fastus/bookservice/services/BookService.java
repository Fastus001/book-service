package pl.fastus.bookservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.fastus.bookservice.dao.BookResponse;
import pl.fastus.bookservice.domain.Book;
import pl.fastus.bookservice.mappers.BookMapper;
import pl.fastus.bookservice.repository.BookRepository;

/**
 * Created by Tom - 29.05.2021
 */
@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    public BookResponse getByIsbn(String isbn) {
        return mapper.toBookResponse(repository.findBookByIsbn(isbn));
    }
}
