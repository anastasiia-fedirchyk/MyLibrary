package ua.mk.fedirchyk.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.mk.fedirchyk.entity.Category;
import ua.mk.fedirchyk.model.CategoryRequest;
import ua.mk.fedirchyk.repositories.category.CategoryRepository;

import java.util.List;

@Service
@Transactional
public class CategoryDefaultService implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryDefaultService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getCategoryName());
        category.setDescription(categoryRequest.getDescription());

        return categoryRepository.create(category);
    }

    @Override
    public Category update(Category c) {
        return categoryRepository.update(c);
    }

    @Override
    public int delete(Long c) {
        return categoryRepository.delete(c);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();

    }

    @Override
    public Category find(Long id) {
        return categoryRepository.find(id);
    }
}
