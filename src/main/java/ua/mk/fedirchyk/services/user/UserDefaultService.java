package ua.mk.fedirchyk.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.mk.fedirchyk.controllers.usercontroller.request.CreateUserRequest;
import ua.mk.fedirchyk.entity.User;
import ua.mk.fedirchyk.repositories.user.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDefaultService implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserDefaultService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(CreateUserRequest u) {
       // final String delimiter = " ";
        User user = new User();

       // user.setUserName(u.getFirstName() + delimiter + u.getLastName());
        System.out.println(u);

        user.setUserName(u.getFirstName());
        user.setLastName(u.getLastName());
        user.setEmial(u.getEmial());
        user.setPassword(u.getPassword());

        return userRepository.create(user);
    }

    @Override
    public User update(User u) {
        return userRepository.update(u);
    }

    @Override
    public int delete(User u) {
        return userRepository.delete(u);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User find(Long id) {
        return userRepository.find(id);
    }


}
