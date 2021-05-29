package pl.fastus.bookservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.fastus.bookservice.dao.BookResponse;
import pl.fastus.bookservice.services.BookService;


/**
 * Created by Tom - 29.05.2021
 */
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
@RestController
public class BookController {

    private final BookService service;

    @GetMapping("/{isbn}")
    public BookResponse bookByISBN(@PathVariable String isbn){
        System.out.println("isbn = " + isbn);
        return service.getByIsbn(isbn);
    }
}
