package ua.mk.fedirchyk.controllers.categorycontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.mk.fedirchyk.controllers.bookcontroller.CreateBookRequest;
import ua.mk.fedirchyk.entity.Category;
import ua.mk.fedirchyk.model.CategoryRequest;
import ua.mk.fedirchyk.services.category.CategoryService;

@Controller
@RequestMapping(path = "/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("category", new CategoryRequest());
        return "category";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity categoryCreate(@ModelAttribute("category") CategoryRequest category) {
        categoryService.create(category);
        return ResponseEntity.ok("Category created");
    }

    @RequestMapping(path = "/get/{categoryId}", method = RequestMethod.GET)
    public ResponseEntity categoryGetById(@PathVariable(name = "categoryId") Long CategoryId) {
        return ResponseEntity.ok(categoryService.find(CategoryId));
    }

    @RequestMapping(path = "/get", method = RequestMethod.GET)
    public ResponseEntity categoriesGetAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity categoryUpdate(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.update(category));
    }

    @RequestMapping(path = "/delete/{categoryId}", method = RequestMethod.DELETE)
    public ResponseEntity categoryDelete(@PathVariable(name = "categoryId") Long categoryId) {
        return ResponseEntity.ok(categoryService.delete(categoryId));
    }
}
