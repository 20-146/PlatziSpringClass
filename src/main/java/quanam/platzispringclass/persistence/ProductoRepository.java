package quanam.platzispringclass.persistence;

import org.springframework.stereotype.Repository;
import quanam.platzispringclass.domain.Product;
import quanam.platzispringclass.domain.repository.ProductRepository;
import quanam.platzispringclass.persistence.crud.ProductoCrudRepository;
import quanam.platzispringclass.persistence.entity.Producto;
import quanam.platzispringclass.persistence.mapper.ProductMapper;

import java.util.List;
import java.util.Optional;

@Repository
 public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper mapper;

    public ProductoRepository(ProductoCrudRepository productoCrudRepository, ProductMapper mapper) {
        this.productoCrudRepository = productoCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

//    @Override
//    public Optional<List<Product>> getByCategory(int categoryId) {
//        List<Producto> productos = productoCrudRepository.findById_categoriaOrderByNombreProductoAsc(categoryId);
//        return Optional.of(mapper.toProducts(productos));
//    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
         return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(int productId) {
        productoCrudRepository.deleteById(productId);
    }

}
