package com.calorie.tracker.breakfast;

import com.calorie.tracker.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreakfastRepository extends JpaRepository<Breakfast, Integer> {
    Breakfast findById(int breakfastId);

}
