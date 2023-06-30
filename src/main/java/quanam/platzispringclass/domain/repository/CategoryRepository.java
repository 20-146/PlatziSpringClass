package quanam.platzispringclass.domain.repository;

import quanam.platzispringclass.domain.Category;
import quanam.platzispringclass.domain.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    List<Category> getAll();
    Optional<Category> getCategory(int categoryId);
    Category save(Category category);
    void delete(int categoryId);
}
