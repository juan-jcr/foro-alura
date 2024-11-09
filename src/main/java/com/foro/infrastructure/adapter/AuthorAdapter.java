package com.foro.infrastructure.adapter;

import com.foro.domain.model.Author;
import com.foro.domain.port.IAuthorPersistence;
import com.foro.infrastructure.adapter.mapper.IAuthorMapper;
import com.foro.infrastructure.adapter.repository.IAuthorRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthorAdapter implements IAuthorPersistence {
    private final IAuthorRepository repository;
    private final IAuthorMapper mapper;

    public AuthorAdapter(IAuthorRepository repository, IAuthorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Author> findByEmail(String email) {
        return repository.findByEmail(email)
                .map(mapper::toAuthor);
    }

    @Override
    public Author save(Author author) {
        return mapper.toAuthor(
                repository.save(mapper.toAuthorEntity(author)));
    }
}
