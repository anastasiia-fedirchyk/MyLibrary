package ua.mk.fedirchyk.repositories.author;

import ua.mk.fedirchyk.entity.Author;

import java.util.List;


public interface AuthorRepository {

    Author create(Author a);

    Author update(Author a);

    int delete(Author a);

    List<Author> findAll();

    Author find(Long id);
}
