package ua.mk.fedirchyk.repositories.user;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.mk.fedirchyk.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
@Transactional
public class DefaultUserRepository implements UserRepository {

    @PersistenceContext
    public EntityManager em;

    @Override
    public User create(User u) {

        System.out.println("user for create "+u);
        User userFromDb = em.merge(u);
        System.out.println("user from db "+ userFromDb);

        return userFromDb ;
    }

    @Override
    public User update(User u) {

        em.merge(u);


        return null;
    }

    @Override
    public int delete(User u) {

        em.remove(u);


        return 0;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> namedQuery = em.createQuery("SELECT u FROM USER", User.class);
        return namedQuery.getResultList();
    }

    @Override
    public User find(Long id) {
        return em.find(User.class, id);
    }
}
