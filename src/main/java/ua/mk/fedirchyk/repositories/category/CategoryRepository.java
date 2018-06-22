package ua.mk.fedirchyk.repositories.category;

import ua.mk.fedirchyk.entity.Category;

import java.util.List;

public interface CategoryRepository {

    Category create(Category c);

    Category update(Category c);

    int delete(Long c);

    List<Category> findAll();

    Category find(Long id);
}
