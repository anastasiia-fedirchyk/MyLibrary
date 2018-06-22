package ua.mk.fedirchyk.repositories.user;

import ua.mk.fedirchyk.entity.User;

import java.util.List;

public interface UserRepository {

    User create(User u);

    User update(User u);

    int delete(User u);

    List<User> findAll();

    User find(Long id);
}
