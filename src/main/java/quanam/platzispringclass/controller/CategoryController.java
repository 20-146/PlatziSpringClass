package quanam.platzispringclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import quanam.platzispringclass.domain.Category;
import quanam.platzispringclass.domain.service.CategoryService;
import quanam.platzispringclass.persistence.entity.Categoria;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping()
    public List<Category> getAll() {
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @PostMapping("/add")
    public Category save(@RequestBody Category category) {
        return this.categoryService.save(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int categoryId) {
        categoryService.delete(categoryId);
    }
}
