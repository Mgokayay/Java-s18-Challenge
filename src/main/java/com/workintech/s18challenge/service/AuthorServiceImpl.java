package com.workintech.s18challenge.service;

import com.workintech.s18challenge.entity.Author;
import com.workintech.s18challenge.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;
    @Override
    public Author findById(long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);

        return authorOptional.orElseThrow(() -> new RuntimeException("Author with given id is not found: "+ id));
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
