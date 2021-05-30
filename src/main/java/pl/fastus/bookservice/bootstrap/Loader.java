package pl.fastus.bookservice.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
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
@Profile("!prod")
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

        Book book1 = new Book();
        book1.setIsbn("123-456-789");
        book1.setTitle("Title2");
        book1.setNumberOfPages(650);

        author.addBook(book);
        author.addBook(book1);

        authorRepository.save(author);
        bookService.saveBook(book);
        bookService.saveBook(book1);
    }
}
