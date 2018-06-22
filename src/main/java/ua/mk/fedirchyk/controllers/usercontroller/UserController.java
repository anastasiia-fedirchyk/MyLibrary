package ua.mk.fedirchyk.controllers.usercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.mk.fedirchyk.controllers.usercontroller.request.CreateUserRequest;
import ua.mk.fedirchyk.entity.User;
import ua.mk.fedirchyk.services.user.UserService;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/get/{userId}", method = RequestMethod.GET)
    public ResponseEntity userGetById(@PathVariable(name = "userId") Long UserId) {
        return ResponseEntity.ok(userService.find(UserId));
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity usersGetAll() {
        return ResponseEntity.ok(userService.findAll());
    }


    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity userCreate(ModelAndView modelAndView,
                                     @ModelAttribute("user") CreateUserRequest user,
                                     BindingResult bindingResult,
                                     HttpServletRequest request) {

        User savedUser = userService.create(user);
        return ResponseEntity.ok("User with name "+savedUser.getUserName()+  " created");
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity userUpdate(@RequestBody User user) {
        return ResponseEntity.ok(userService.update(user));
    }

    @RequestMapping(path = "/delete/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity userDelete(@PathVariable(name = "userId") Long userId) {
        User user = userService.find(userId);
        return ResponseEntity.ok(userService.delete(user));
    }

}
