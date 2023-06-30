package quanam.platzispringclass.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import quanam.platzispringclass.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

//    List<Producto> findById_categoriaOrderByNombreProductoAsc(int id_categoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
