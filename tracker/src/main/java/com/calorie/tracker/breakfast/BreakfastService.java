package com.calorie.tracker.breakfast;

import com.calorie.tracker.product.Product;
import com.calorie.tracker.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BreakfastService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    BreakfastRepository breakfastRepository;

    public Breakfast getBreakfastById(int breakfastId) {
        Breakfast breakfast = breakfastRepository.findById(breakfastId);
        return breakfast;
    }

    public Breakfast saveBreakfast(Breakfast breakfast) {
        return breakfastRepository.save(breakfast);
    }


}



//    public void addProductToBreakfast(int id, int breakfastId) {
//
//        // Find the product by ID
//        Optional<Product> productOptional = Optional.ofNullable(productRepository.findById(id));
//        if (productOptional.isEmpty()) {
//            throw new IllegalArgumentException("Product not found");
//        }
//        Product product = productOptional.get();
//
//        // Find the breakfast by ID
//        Optional<Breakfast> breakfastOptional = Optional.ofNullable(breakfastRepository.findById(breakfastId));
//        if (breakfastOptional.isEmpty()) {
//            throw new IllegalArgumentException("Breakfast not found");
//        }
//        Breakfast breakfast = breakfastOptional.get();
//
//        // Add the product to the breakfast and save the changes
//        breakfast.addProduct(product);
//        breakfastRepository.save(breakfast);
//    }