package pl.fastus.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.fastus.bookservice.domain.Author;

/**
 * Created by Tom - 29.05.2021
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
