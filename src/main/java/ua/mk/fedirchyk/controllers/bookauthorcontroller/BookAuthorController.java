package ua.mk.fedirchyk.controllers.bookauthorcontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.mk.fedirchyk.entity.BookAuthor;

import javax.annotation.security.PermitAll;

@Controller
@RequestMapping(path = "/book-author")
public class BookAuthorController {

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity bookAuthorGetById(@PathVariable String lastName) {
        return ResponseEntity.ok("Book Author created");
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity bookAuthorCreate(@RequestBody BookAuthor bookAuthor) {
        return ResponseEntity.ok("Book Author created");
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity bookAuthorUpdate(@RequestBody BookAuthor bookAuthor) {
        return ResponseEntity.ok("Book Author updated");
    }

    @RequestMapping(path = "/delete/ {authorId}", method = RequestMethod.DELETE)
    public ResponseEntity bookAuthorDelete(@PathVariable(name = "lastName") String lastName) {
        return ResponseEntity.ok("Book Author deleted");
    }

}

