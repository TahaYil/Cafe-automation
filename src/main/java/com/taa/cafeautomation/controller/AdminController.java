package com.taa.cafeautomation.controller;


import com.taa.cafeautomation.entitiy.Product;
import com.taa.cafeautomation.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @PutMapping("/add")
    public ResponseEntity<Product> add(@RequestParam String name,
                                       @RequestParam double price,
                                       @RequestParam String text,
                                       @RequestParam int categoryId) {
        return ResponseEntity.ok(productService.save(name,price,categoryId,text)) ;
    }
}
