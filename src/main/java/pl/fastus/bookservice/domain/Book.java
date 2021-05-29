package pl.fastus.bookservice.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by Tom - 29.05.2021
 */
@EqualsAndHashCode(exclude = "author")
@ToString(exclude = "author")
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String isbn;

    private String title;
    private int numberOfPages;

    @ManyToOne
    private Author author;
}
