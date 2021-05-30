package pl.fastus.bookservice.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.fastus.bookservice.domain.Author;
import pl.fastus.bookservice.domain.Book;
import pl.fastus.bookservice.exception.BookNotFoundByIdException;
import pl.fastus.bookservice.repository.BookRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class BookServiceTest {

    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    void init(){
        bookRepository = Mockito.mock(BookRepository.class);
        bookService = new BookService(bookRepository);
    }

    @Test
    void saveBook() {

    }

    @Test
    void getByIsbn() {
    }

    @Test
    void getAllBooks() {
        //given
        Book book1 = Book.builder().id(12L).build();
        given(bookRepository.findAll()).willReturn(List.of(book1));
        //when
        final List<Book> books = bookService.getAllBooks();
        //then
        assertEquals(1, books.size());
        verify(bookRepository, times(1)).findAll();
    }

    @Test
    void findByAuthor() {
        Author author = Author.builder().id(10L).build();
        Book book1 = Book.builder().id(12L).build();
        Book book2 = Book.builder().id(13L).build();
        Long id = 12L;

        given(bookRepository.findAllByAuthor(author)).willReturn(List.of(book1, book2));

        final List<Long> longs = bookService.findByAuthor(author);

        assertEquals(2, longs.size());

    }

    @Test
    void getById() {
        Book book1 = Book.builder().id(12L).build();
        given(bookRepository.findById(12L)).willReturn(Optional.of(book1));

        final Book foundBook = bookService.getById(12L);

        assertEquals(12, foundBook.getId());
        assertThat(foundBook).isEqualTo(book1);

        verify(bookRepository).findById(any());
    }

    @Test
    void findByIdBookMissing(){
        given(bookRepository.findById(12L)).willReturn(Optional.empty());

        assertThatThrownBy(() -> bookService.getById(12L)).isExactlyInstanceOf(BookNotFoundByIdException.class)
                .hasMessageContaining("12");

    }
}
