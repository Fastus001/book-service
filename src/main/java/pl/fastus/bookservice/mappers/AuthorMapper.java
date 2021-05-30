package pl.fastus.bookservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.fastus.bookservice.domain.Author;
import pl.fastus.bookservice.domain.dto.AuthorDto;

import java.util.List;

/**
 * Created by Tom - 29.05.2021
 */
@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(source = "ids", target = "bookIds")
    AuthorDto toDto(Author author, List<Long> ids);
}
