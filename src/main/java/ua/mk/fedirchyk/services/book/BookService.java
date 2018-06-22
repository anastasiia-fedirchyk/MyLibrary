package ua.mk.fedirchyk.services.book;

import ua.mk.fedirchyk.entity.Book;

import java.util.List;

public interface BookService {
    Book create (Book b);
    Book update (Book b);
    int delete (Long b);
    List<Book> findAll ();
    Book find (Long id);
}
