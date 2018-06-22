package ua.mk.fedirchyk.repositories.book;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.mk.fedirchyk.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class DefaultBookRepository implements BookRepository {
    @PersistenceContext
    public EntityManager em;
    @Override
    public Book create(Book b) {

        Book bookFromDb = em.merge(b);


        return bookFromDb ;
    }

    @Override
    public Book update(Book b) {

        em.merge(b);


        return null;
    }

    @Override
    public int delete(Long b) {

        em.remove(b);


        return 0;
    }

    @Override
    public List<Book> findAll() {
        TypedQuery<Book> namedQuery = em.createQuery("SELECT b FROM Book b", Book.class);
        return namedQuery.getResultList();
    }

    @Override
    public Book find(Long id) {
        return em.find(Book.class, id);

    }
}
