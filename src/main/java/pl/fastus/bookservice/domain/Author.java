package pl.fastus.bookservice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom - 29.05.2021
 */
@EqualsAndHashCode(exclude = "books")
@ToString(exclude = "books")
@Data
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String sureName;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        if(books != null){
            books.add(book);
            book.setAuthor(this);
        }
    }
}
