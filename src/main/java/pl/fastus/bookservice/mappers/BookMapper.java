package pl.fastus.bookservice.mappers;

/**
 * Created by Tom - 29.05.2021
 */

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.fastus.bookservice.domain.Book;
import pl.fastus.bookservice.domain.dto.BookDto;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "author", target = "author")
    BookDto toBookDto(Book book);

    Book toBook(BookDto bookDto);
}
