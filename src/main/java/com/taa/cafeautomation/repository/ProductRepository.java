package com.taa.cafeautomation.repository;

import com.taa.cafeautomation.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository< Product , Integer> {
    public Product findByName(String name);
    public Product findById(int id);
    //public Product create(Product product);
    //public Product update(Product product);
}
