package ua.mk.fedirchyk.services.user;

import ua.mk.fedirchyk.controllers.usercontroller.request.CreateUserRequest;
import ua.mk.fedirchyk.entity.User;

import java.util.List;

public interface UserService {

    User create(CreateUserRequest u);

    User update(User u);

    int delete(User u);

    List<User> findAll();

    User find(Long id);

}
