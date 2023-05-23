package com.restapi.shop.presentationLayer;

import com.restapi.shop.pojo.Product;
import com.restapi.shop.serviceLayer.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shop/product")
public class ProductController {

    private final ProductService service;
    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") Integer id){
        return service.getById(id);
    }

    @PostMapping()
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<Product>(service.add(product),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@PathVariable("id") Integer id,
                                        @RequestBody Product product){
        return new ResponseEntity<Product>(service.editProduct(id,product),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return new ResponseEntity<String>("Deleted successfully",HttpStatus.OK);
    }
}
