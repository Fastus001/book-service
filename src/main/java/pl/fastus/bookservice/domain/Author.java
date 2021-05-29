package pl.fastus.bookservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom - 29.05.2021
 */
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