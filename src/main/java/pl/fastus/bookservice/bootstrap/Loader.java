package pl.fastus.bookservice.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.fastus.bookservice.domain.Author;
import pl.fastus.bookservice.domain.Book;
import pl.fastus.bookservice.repository.AuthorRepository;
import pl.fastus.bookservice.services.BookService;

/**
 * Created by Tom - 29.05.2021
 */
@RequiredArgsConstructor
@Component
public class Loader implements CommandLineRunner {

    private final BookService bookService;
    private final AuthorRepository authorRepository;


    @Override
    public void run(String... args){
        Author author = new Author();
        author.setName("Poul");
        author.setSureName("Rudd");

        Book book = new Book();
        book.setIsbn("ISBN");
        book.setTitle("Title");
        book.setNumberOfPages(250);

        author.addBook(book);

        authorRepository.save(author);
        bookService.saveBook(book);
    }
}
