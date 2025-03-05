package com.taa.cafeautomation.service;

import com.taa.cafeautomation.entitiy.Category;
import com.taa.cafeautomation.entitiy.Product;
import com.taa.cafeautomation.repository.CategoryRepository;
import com.taa.cafeautomation.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product update(Product product) {
        Product newProduct=productRepository.findById(product.getId());
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setCategory(product.getCategory());
        newProduct.setText(product.getText());
        return productRepository.save(newProduct);
    }
    public Product save(String name , double price , int categoryId, String text) {
        Product product=new Product();
        Category category=categoryRepository.findById(categoryId).orElse(null);
        product.setName(name);
        product.setPrice(price);
        product.setText(text);
        product.setCategory(category);
        return productRepository.save(product);
    }
}
