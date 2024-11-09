package com.foro.infrastructure.adapter.repository;

import com.foro.infrastructure.adapter.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAuthorRepository extends JpaRepository<AuthorEntity, Long> {
    Optional<AuthorEntity> findByEmail(String email);
}
