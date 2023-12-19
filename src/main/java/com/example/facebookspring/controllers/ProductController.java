package com.example.facebookspring.controllers;

import com.example.facebookspring.model.Brand;
import com.example.facebookspring.model.Product;
import com.example.facebookspring.repository.BrandRepository;
import com.example.facebookspring.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    final ProductRepository productRepository;
    final BrandRepository brandRepository;

    public ProductController(ProductRepository productRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;

    }

    @GetMapping("/brands/{id}/products")
    public List<Product> getProductsByBrandId(@PathVariable int id){
        Optional<Brand> brand = brandRepository.findById(id);
        return brand.map(Brand::getProducts).orElse(null);
    }

    @GetMapping("/brands/{id}/products/{productId}")
    public Product getProductByBrandId(@PathVariable int id, @PathVariable int productId){
        Optional<Brand> brand = brandRepository.findById(id);
        Optional<Product> product = productRepository.findById(productId);
        if(brand.isPresent() && product.isPresent()){
            if(product.get().getBrand().getId() == brand.get().getId()){
                return product.get();
            }
        }
        return null;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

}
