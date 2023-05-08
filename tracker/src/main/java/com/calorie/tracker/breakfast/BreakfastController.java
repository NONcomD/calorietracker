package com.calorie.tracker.breakfast;

import com.calorie.tracker.product.Product;
import com.calorie.tracker.product.ProductRepository;
import com.calorie.tracker.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BreakfastController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    BreakfastService breakfastService;
    @Autowired
    BreakfastRepository breakfastRepository;


    @PostMapping("/breakfast/new")
    public ResponseEntity<Breakfast> createBreakfast(@RequestBody Breakfast breakfast) {
        breakfastService.saveBreakfast(breakfast);
        return new ResponseEntity<>(breakfast, HttpStatus.CREATED);
    }


    @GetMapping("/breakfasts/{breakfastId}")
    public String breakfast(@PathVariable int breakfastId, Model model) {
        Breakfast breakfast = breakfastService.getBreakfastById(breakfastId);
        model.addAttribute("breakfast", breakfast);
        return "breakfast";
    }



    @PostMapping("/breakfasts")
    public ResponseEntity<Breakfast> addToBreakfast(@RequestParam("id") int id) {
        Product product = productRepository.findById(id);
        Breakfast breakfast = new Breakfast();
        breakfast.addProduct(product);
        breakfastRepository.save(breakfast);
        return ResponseEntity.ok(breakfast);
    }
}




//    @GetMapping("/breakfast")
//    public ResponseEntity<BreakfastList> breakfastList() {
//        return new ResponseEntity<>(
//                new BreakfastList(breakfastRepository.findAll()),
//                HttpStatus.OK
//        );
//    }

//    @PostMapping("/breakfasts")
//    public ResponseEntity<Breakfast> addToBreakfast(@RequestParam("id") int id) {
//        Product product = productRepository.findById(id);
//        Breakfast breakfast = new Breakfast();
//        breakfast.setProduct(product);
//        breakfastRepository.save(breakfast);
//        return ResponseEntity.ok(breakfast);
//    }

//    @PostMapping("/breakfasts")
//    public ResponseEntity<Breakfast> addToBreakfast(@RequestParam("id") int id) {
//        Product product = productRepository.findById(id);
//        Breakfast breakfast = new Breakfast();
//        breakfast.setProduct(product);
//        breakfastRepository.save(breakfast);
//        return ResponseEntity.ok(breakfast);
//    }

