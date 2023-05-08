package com.calorie.tracker.product;

import com.calorie.tracker.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findById(int id);
}
