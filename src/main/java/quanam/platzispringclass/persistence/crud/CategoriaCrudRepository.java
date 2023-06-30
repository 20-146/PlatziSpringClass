package quanam.platzispringclass.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import quanam.platzispringclass.persistence.entity.Categoria;

public interface CategoriaCrudRepository extends CrudRepository<Categoria, Integer> {
}
