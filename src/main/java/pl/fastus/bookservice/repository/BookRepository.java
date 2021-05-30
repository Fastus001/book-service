package pl.fastus.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fastus.bookservice.domain.Author;
import pl.fastus.bookservice.domain.Book;

import java.util.List;
import java.util.Optional;

/**
 * Created by Tom - 29.05.2021
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);

    List<Book> findAllByAuthor(Author author);

}
