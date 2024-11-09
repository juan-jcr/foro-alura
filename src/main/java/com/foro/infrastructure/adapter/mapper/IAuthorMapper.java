package com.foro.infrastructure.adapter.mapper;

import com.foro.domain.model.Author;
import com.foro.infrastructure.adapter.entity.AuthorEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAuthorMapper {
    AuthorEntity toAuthorEntity(Author author);

    Author toAuthor(AuthorEntity entity);

    List<Author> toAuthorList(List<AuthorEntity> entityList);
}
