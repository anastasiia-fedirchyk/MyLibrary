package ua.mk.fedirchyk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.mk.fedirchyk.controllers.usercontroller.request.CreateUserRequest;

@Controller
public class MainController {
    @RequestMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("user",new CreateUserRequest());

        return "index";
    }

}
