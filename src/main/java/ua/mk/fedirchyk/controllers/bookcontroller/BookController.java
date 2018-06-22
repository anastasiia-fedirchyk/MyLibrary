package ua.mk.fedirchyk.controllers.bookcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.mk.fedirchyk.entity.Author;
import ua.mk.fedirchyk.entity.Book;
import ua.mk.fedirchyk.entity.Publisher;
import ua.mk.fedirchyk.entity.Category;
import ua.mk.fedirchyk.services.author.AuthorService;
import ua.mk.fedirchyk.services.book.BookService;
import ua.mk.fedirchyk.services.category.CategoryService;
import ua.mk.fedirchyk.services.publisher.PublisherService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/book")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final PublisherService publisherService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService, CategoryService categoryService, PublisherService publisherService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.publisherService = publisherService;
    }

    @RequestMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("book", new CreateBookRequest());
        model.addAttribute("authors", authorService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("publishers", publisherService.findAll());

        return "book";
    }

    @RequestMapping("/find")
    public String viewFindBookPage(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "findBook";
    }

    @RequestMapping(path = "/get/{bookId}", method = RequestMethod.GET)
    public ResponseEntity bookGetById(@PathVariable(name = "bookId") Long BookId) {
        return ResponseEntity.ok(bookService.find(BookId));
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity booksGetAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity bookCreate(ModelAndView modelAndView,
                                     @ModelAttribute("book") CreateBookRequest book,
                                     BindingResult bindingResult,
                                     HttpServletRequest request) {
        Book b = new Book();
        b.setBookName(book.getBookName());

        List<Author> authors = new ArrayList<>();

        List<Category> categories = new ArrayList<>();

        List<Publisher> publishers = new ArrayList<>();

        for (Long catId : book.getCategoriesId()) {
            categories.add(categoryService.find(catId));
        }
        b.setCategory(categories);
        for (Long authorId : book.getAuthorIds()) {
            authors.add(authorService.find(authorId));
        }
        for (Long publisherId:book.getPublishersId()){
            publishers.add (publisherService.find(publisherId));
        }
        b.setAuthors(authors);

        b.setPublishers(publishers);


        bookService.create(b);
        return ResponseEntity.ok("Book created");
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity bookUpdate(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.update(book));
    }

    @RequestMapping(path = "/delete/{bookId}", method = RequestMethod.DELETE)
    public ResponseEntity bookDelete(@PathVariable(name = "bookId") Long bookId) {
        return ResponseEntity.ok(bookService.delete(bookId));
    }
}
