package ua.mk.fedirchyk.repositories.publisher;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.mk.fedirchyk.entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class DefaultPublisherRepository implements PublisherRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Publisher create(Publisher p) {
       Publisher publisherFromDb = em.merge(p);

        return publisherFromDb;
    }

    @Override
    public Publisher update(Publisher p) {
        Publisher updatedPublisher = em.merge(p);

        return updatedPublisher;
    }

    @Override
    public int delete(Publisher p) {

        em.remove(p);

        return 0;
    }

    @Override
    public List<Publisher> findAll() {
        TypedQuery<Publisher> namedQuery = em.createQuery("SELECT p FROM Publisher p", Publisher.class);
        return namedQuery.getResultList();
    }

    @Override
    public Publisher find(Long id) {
        return em.find(Publisher.class, id);
    }
}
