package ua.mk.fedirchyk.repositories.author;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.mk.fedirchyk.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class DefaultAuthorRepository implements AuthorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Author create(Author a) {
        Author authorFromDb = em.merge(a);

        return authorFromDb;
    }

    @Override
    public Author update(Author a) {
        Author updatedAuthor = em.merge(a);

        return updatedAuthor;
    }

    @Override
    public int delete(Author a) {

        em.remove(a);

        return 0;
    }

    @Override
    public List<Author> findAll() {
        TypedQuery<Author> namedQuery = em.createQuery("SELECT a FROM Author a", Author.class);
        return namedQuery.getResultList();
    }

    @Override
    public Author find(Long id) {
        return em.find(Author.class, id);
    }
}
