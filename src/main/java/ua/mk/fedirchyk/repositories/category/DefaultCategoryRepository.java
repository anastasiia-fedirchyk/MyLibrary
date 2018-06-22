package ua.mk.fedirchyk.repositories.category;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.mk.fedirchyk.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class DefaultCategoryRepository implements CategoryRepository {
    @PersistenceContext
    public EntityManager em;

    @Override
    public Category create(Category c) {
        Category categoryFromDb = em.merge(c);
        return categoryFromDb;
    }

    @Override
    public Category update(Category c) {

        em.merge(c);

        return null;
    }

    @Override
    public int delete(Long c) {

        em.remove(c);

        return 0;
    }

    @Override
    public List<Category> findAll() {
        TypedQuery<Category> namedQuery = em.createQuery("SELECT c FROM Category c", Category.class);
        return namedQuery.getResultList();
    }

    @Override
    public Category find(Long id) {
        return em.find(Category.class, id);
    }
}
