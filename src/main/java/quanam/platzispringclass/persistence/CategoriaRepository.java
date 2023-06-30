package quanam.platzispringclass.persistence;

import org.springframework.stereotype.Repository;
import quanam.platzispringclass.domain.Category;
import quanam.platzispringclass.domain.repository.CategoryRepository;
import quanam.platzispringclass.persistence.crud.CategoriaCrudRepository;
import quanam.platzispringclass.persistence.entity.Categoria;
import quanam.platzispringclass.persistence.mapper.CategoryMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {

    private CategoriaCrudRepository categoriaCrudRepository;
    private CategoryMapper mapper;

    public CategoriaRepository(CategoriaCrudRepository categoriaCrudRepository, CategoryMapper mapper) {
        this.categoriaCrudRepository = categoriaCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Category> getAll() {
        List<Categoria> categorias = (List<Categoria>) categoriaCrudRepository.findAll();
        return mapper.toCategories(categorias);
    }

    @Override
    public Optional<Category> getCategory(int categoryId) {
        return categoriaCrudRepository.findById(categoryId).map(cat -> mapper.toCategory(cat));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategoria(category);
        return mapper.toCategory(categoriaCrudRepository.save(categoria));
    }

    @Override
    public void delete(int categoryId) {
        categoriaCrudRepository.deleteById(categoryId);
    }
}
