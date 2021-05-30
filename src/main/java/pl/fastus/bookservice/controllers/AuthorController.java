package pl.fastus.bookservice.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.fastus.bookservice.domain.Author;
import pl.fastus.bookservice.domain.dto.AuthorDto;
import pl.fastus.bookservice.mappers.AuthorMapper;
import pl.fastus.bookservice.services.AuthorService;
import pl.fastus.bookservice.services.BookService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Tom - 29.05.2021
 */
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/author")
@RestController
public class AuthorController {

    private final AuthorService service;
    private final BookService bookService;
    private final AuthorMapper mapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDto> allAuthors(){
        return service.findAll()
                .stream()
                .map(this::findBookId)
                .collect(Collectors.toList());

    }

    private AuthorDto findBookId(Author author){
        final List<Long> booksByAuthor = bookService.findByAuthor(author);
        System.out.println("booksByAuthor = " + booksByAuthor);
        final AuthorDto authorDto = mapper.toDto(author, booksByAuthor);
        return authorDto;
    }
}
