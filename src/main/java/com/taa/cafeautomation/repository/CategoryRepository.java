package com.taa.cafeautomation.repository;

import com.taa.cafeautomation.entitiy.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
