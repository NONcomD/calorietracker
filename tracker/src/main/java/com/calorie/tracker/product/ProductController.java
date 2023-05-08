package com.calorie.tracker.product;


import com.calorie.tracker.breakfast.Breakfast;
import com.calorie.tracker.breakfast.BreakfastRepository;
import com.calorie.tracker.product.Product;
import com.calorie.tracker.product.ProductRepository;
import com.calorie.tracker.product.ProductService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;
    @Autowired
    BreakfastRepository breakfastRepository;

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> productById(@PathVariable int id) {
        return new ResponseEntity<>(
                productRepository.findById(id),
                HttpStatus.OK
        );
    }


    @GetMapping("/products")
    public ResponseEntity<Products> products() {
        return new ResponseEntity<>(
                new Products(productRepository.findAll()),
                HttpStatus.OK
        );
    }


    @PostMapping("/products/new")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }


    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product existingProduct = productService.getProductById(id);
        if (existingProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            existingProduct.setProtein(product.getProtein());
            existingProduct.setFat(product.getFat());
            existingProduct.setCarbs(product.getCarbs());
            existingProduct.setCalories(product.getCalories());
            existingProduct.setWeight(product.getWeight());

            productService.saveProduct(existingProduct);
            return new ResponseEntity<>(existingProduct, HttpStatus.OK);
        }
    }

    // DELETE a product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}









//    @PostMapping("/breakfast/{id}")
//    public String addToBreakfast(@PathVariable int id) {
//        Product product = productRepository.findById(id);
//        Breakfast breakfast = new Breakfast();
//        breakfast.setProduct(product);
//        breakfastRepository.save(breakfast);
//        return "redirect:/products/breakfast"+ id;
//    }







//    // GET all products
//    @GetMapping("/products")
//    public ResponseEntity<List<Product>> getAllProducts() {
//        List<Product> products = productService.getAllProducts();
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }
//
//    // GET a single product by ID
//    @GetMapping("/products/{id}")
//    public ResponseEntity<Product> getProductById(@PathVariable int id) {
//        Product product = productService.getProductById(id);
//        if (product == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>(product, HttpStatus.OK);
//        }
//    }

//    // POST a new product
//    @PostMapping("/products/new")
//    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
//        productService.saveProduct(product);
//        return new ResponseEntity<>(product, HttpStatus.CREATED);
//    }