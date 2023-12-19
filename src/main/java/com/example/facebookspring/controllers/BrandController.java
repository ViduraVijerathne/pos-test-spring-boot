package com.example.facebookspring.controllers;

import com.example.facebookspring.model.Brand;
import com.example.facebookspring.model.Product;
import com.example.facebookspring.repository.BrandRepository;
import com.example.facebookspring.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BrandController {
    final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping("/brands")
    public List<Brand> getAllBrands(){
        return brandRepository.findAll();
    }

    @GetMapping("/brands/{id}")
    public Brand getBrandById(@PathVariable int id){
        Optional<Brand> brand = brandRepository.findById(id);
        return brand.orElse(null);
    }


}
