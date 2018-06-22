package ua.mk.fedirchyk.services.author;

import ua.mk.fedirchyk.controllers.authorcontroller.CreateAuthorRequest;
import ua.mk.fedirchyk.entity.Author;

import java.util.List;

public interface AuthorService {

    Author create(CreateAuthorRequest a);

    Author update(CreateAuthorRequest a);

    int delete(Author a);

    List<Author> findAll();

    Author find(Long id);
}
