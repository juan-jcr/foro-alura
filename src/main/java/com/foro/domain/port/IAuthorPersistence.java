package com.foro.domain.port;

import com.foro.domain.model.Author;
import com.foro.domain.model.Topic;

import java.util.Optional;

public interface IAuthorPersistence {
    Optional<Author> findByEmail(String email);
    Author save(Author author);
}
