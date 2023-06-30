package quanam.platzispringclass.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quanam.platzispringclass.domain.Product;
import quanam.platzispringclass.domain.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }
//
//    public Optional<List<Product>> getByCategory(int categoryId){
//        return productRepository.getByCategory(categoryId);
//    }

    public Product save(Product product){
        return productRepository.save(product);
    }
    public void delete(int productId) throws Exception {
        if (productRepository.getProduct(productId).isPresent() ) {
            productRepository.delete(productId);
        }else
            throw new Exception("Id not found");

    }

}
