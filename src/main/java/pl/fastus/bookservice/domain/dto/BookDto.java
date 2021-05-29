package pl.fastus.bookservice.domain.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Created by Tom - 29.05.2021
 */
@Data
public class BookDto {

    @NotBlank
    private String isbn;

    @NotBlank
    private String title;

    @Min(value = 10, message = "At least 10 pages")
    private int numberOfPages;
    private AuthorDto author;
}
