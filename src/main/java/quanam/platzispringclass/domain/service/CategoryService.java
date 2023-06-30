package quanam.platzispringclass.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quanam.platzispringclass.domain.Category;
import quanam.platzispringclass.domain.repository.CategoryRepository;
import quanam.platzispringclass.persistence.entity.Categoria;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int categoryId) {
        return categoryRepository.getCategory(categoryId);
    }

    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    public void delete(int categoryId) {
        categoryRepository.delete(categoryId);
    }
}
