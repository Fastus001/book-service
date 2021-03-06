package pl.fastus.bookservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.fastus.bookservice.domain.Author;
import pl.fastus.bookservice.domain.Book;
import pl.fastus.bookservice.domain.dto.AuthorDto;
import pl.fastus.bookservice.domain.dto.BookDto;
import pl.fastus.bookservice.mappers.BookMapper;
import pl.fastus.bookservice.repository.AuthorRepository;
import pl.fastus.bookservice.services.BookService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by Tom - 29.05.2021
 */
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService bookService;
    private final AuthorRepository authorRepository;
    private final BookMapper mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getBooks(){
        return bookService.getAllBooks()
                .stream()
                .map(mapper::toBookDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/isbn/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto bookByISBN(@PathVariable String isbn){
        System.out.println("isbn = " + isbn);
        return mapper.toBookDto(bookService.getByIsbn(isbn));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto bookById(@PathVariable Long id){
        final Book book = bookService.getById(id);
        final List<Long> idsByAuthor = bookService.findByAuthor(book.getAuthor());
        final BookDto bookDto = mapper.toBookDto(book);
        bookDto.getAuthor().setBookIds(idsByAuthor);

        return bookDto;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@Valid @RequestBody BookDto request){
        Book book = bookService.getByIsbn(request.getIsbn());

        if(book != null){
            throw new IllegalArgumentException("Book with this ISBN is already in Data Base");
        }else{
            book = mapper.toBook(request);
            final AuthorDto authorDto = request.getAuthor();
            Author author = authorRepository.findAuthorByNameAndSureName(authorDto.getName(), authorDto.getSureName());
            if(author == null){
                author= new Author();
                author.setName(authorDto.getName());
                author.setSureName(authorDto.getSureName());
            }

            author.addBook(book);
            authorRepository.save(author);
            bookService.saveBook(book);
        }
    }

}
