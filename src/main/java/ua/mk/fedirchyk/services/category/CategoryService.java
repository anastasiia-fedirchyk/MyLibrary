package ua.mk.fedirchyk.services.category;

import ua.mk.fedirchyk.entity.Category;
import ua.mk.fedirchyk.model.CategoryRequest;

import java.util.List;

public interface CategoryService {

    Category create (CategoryRequest categoryRequest);

    Category update (Category c);

    int delete (Long c);

    List<Category> findAll ();

    Category find (Long id);
}
