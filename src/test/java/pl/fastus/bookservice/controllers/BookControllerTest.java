package pl.fastus.bookservice.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import pl.fastus.bookservice.domain.Author;
import pl.fastus.bookservice.domain.Book;
import pl.fastus.bookservice.repository.AuthorRepository;
import pl.fastus.bookservice.repository.BookRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("dev")
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getBookByIdReturnsBook() throws Exception {
        //given
        final Author author = Author.builder().id(1L).build();
        final Book testBook = Book.builder().title("TestBook")
                .isbn("000-000-000")
                .numberOfPages(500)
                .author(author)
                .build();

        author.addBook(testBook);
        authorRepository.save(author);
        bookRepository.save(testBook);


        //when
        mockMvc.perform(get("/api/v1/books/"+testBook.getId()))
                .andExpect(status().is2xxSuccessful());
    }
}
