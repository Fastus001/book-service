package pl.fastus.bookservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.fastus.bookservice.domain.Author;
import pl.fastus.bookservice.repository.AuthorRepository;

/**
 * Created by Tom - 29.05.2021
 */
@RequiredArgsConstructor
@Service
public class AuthorService {

    private final AuthorRepository repository;

    public Author findByNameAndSureName(String name, String sureName){
        return repository.findAuthorByNameAndSureName(name,sureName);
    }
}
