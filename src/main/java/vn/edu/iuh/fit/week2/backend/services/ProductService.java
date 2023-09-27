package vn.edu.iuh.fit.week2.backend.services;

import vn.edu.iuh.fit.week2.backend.models.Product;
import vn.edu.iuh.fit.week2.backend.repositories.ProductRepository;

import java.util.List;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService() {
        productRepository = new ProductRepository();
    }

    public Product create(Product p){
        productRepository.add(p);
        return p;
    }

    public void delete(long id){
        productRepository.delete(id);
    }

    public Product update(Product p){
        productRepository.update(p);
        return p;
    }

    public List<Product> getAll(){
        return productRepository.getAll();
    }
}
