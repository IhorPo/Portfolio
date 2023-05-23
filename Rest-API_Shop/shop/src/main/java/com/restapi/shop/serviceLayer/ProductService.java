package com.restapi.shop.serviceLayer;

import com.restapi.shop.dataAccessLayer.ProductRepository;
import com.restapi.shop.exceptions.ProductNotFoundException;
import com.restapi.shop.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repository;
    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAll(){
        return repository.findAll();
    }

    public Product getById(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("id: "+id)
        );
    }

    public Product add(Product product){
        return repository.save(product);
    }

    public Product editProduct(Integer id, Product p){
        Optional<Product> product = repository.findById(id);
        if(product.isPresent()){
            Product p1 = product.get();
            p1.setName(p.getName());
            p1.setPrice(p.getPrice());
            return repository.save(p1);
        }else {
            throw new ProductNotFoundException("id: "+id);
        }
    }

    public void delete(Integer id){
        Product product = repository.findById(id).orElseThrow(
                () -> new ProductNotFoundException("id:"+id)
        );
        repository.delete(product);
    }
}
