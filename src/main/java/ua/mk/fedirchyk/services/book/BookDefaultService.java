package ua.mk.fedirchyk.services.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.mk.fedirchyk.entity.Book;
import ua.mk.fedirchyk.repositories.book.BookRepository;

import java.util.List;

@Service
@Transactional
public class BookDefaultService implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookDefaultService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book create(Book b) {
        return bookRepository.create(b);
    }

    @Override
    public Book update(Book b) {
        return bookRepository.update(b);
    }

    @Override
    public int delete(Long b) {
        return bookRepository.delete(b);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book find(Long id) {
        return bookRepository.find(id);
    }
}
