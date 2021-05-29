package pl.fastus.bookservice.mappers;

/**
 * Created by Tom - 29.05.2021
 */

import org.mapstruct.Mapper;
import pl.fastus.bookservice.dao.BookResponse;
import pl.fastus.bookservice.domain.Book;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookResponse toBookResponse(Book book);
}
