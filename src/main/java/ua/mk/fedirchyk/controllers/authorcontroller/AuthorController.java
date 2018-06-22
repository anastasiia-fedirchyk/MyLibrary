package ua.mk.fedirchyk.controllers.authorcontroller;

import org.apache.catalina.valves.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.mk.fedirchyk.controllers.usercontroller.request.CreateUserRequest;
import ua.mk.fedirchyk.entity.Author;
import ua.mk.fedirchyk.services.author.AuthorService;

import javax.servlet.http.HttpServletRequest;
import java.time.ZoneId;

@Controller
@RequestMapping(path = "/author")
public class AuthorController {
    private final AuthorService authorService;


    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @RequestMapping("/")
    public String viewAuthor(Model model) {
        model.addAttribute("author", new CreateAuthorRequest());
        return "author";
    }

    @RequestMapping(path = "/get/{authorId}", method = RequestMethod.GET)
    public ResponseEntity authorGetById(@PathVariable(name = "authorId") Long AuthorId) {
        return ResponseEntity.ok(authorService.find(AuthorId));
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity authorGetAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity authorCreate(ModelAndView modelAndView,
                                       @ModelAttribute("author") CreateAuthorRequest author,
                                       BindingResult bindingResult,
                                       HttpServletRequest request) {
        Author savedAuthor = authorService.create(author);
        return ResponseEntity.ok("Author was created with ID - " + savedAuthor.getAuthorId());
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity authorUpdate(@RequestBody CreateAuthorRequest author) {
        return ResponseEntity.ok(authorService.update(author));
    }

    @RequestMapping(path = "/delete/{authorId}", method = RequestMethod.DELETE)
    public ResponseEntity authorDelete(@PathVariable(name = "authorId") Long authorId) {
        Author author = authorService.find(authorId);

        return ResponseEntity.ok(authorService.delete(author));
    }


}
