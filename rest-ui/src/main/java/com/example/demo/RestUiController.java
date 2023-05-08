package com.example.demo;

import com.example.demo.Product.Product;
import com.example.demo.Product.Products;
import com.example.demo.breakfast.Breakfast;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
public class RestUiController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    @GetMapping("/")
    public String viewHomePage(){
        return "/ui/home";
    }

    @GetMapping("/ui/products/{id}")
    public String product(@PathVariable int id, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject("http://localhost:8081/products/" + id, Product.class);
        model.addAttribute("product", product);
        return "/ui/productInfo";
    }

    @GetMapping("/ui/products")
    public String getAllProducts(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Products products = restTemplate.getForObject("http://localhost:8081/products", Products.class);
        model.addAttribute("products", products.getProducts());
        return "/ui/products";
    }

    @PostMapping("/ui/products/new")
    public String createProduct(
            @RequestParam String name,
            @RequestParam double carbs,
            @RequestParam double protein,
            @RequestParam double fat,
            @RequestParam double weight,
            @RequestParam double calories,
            RedirectAttributes attributes) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Product product = new Product(name, carbs, protein, fat, weight, calories);
        HttpEntity<Product> request = new HttpEntity<>(product, headers);

        ResponseEntity<Product> response = restTemplate.postForEntity(
                "http://localhost:8081/products/new", request, Product.class);
        attributes.addFlashAttribute("message", "Product successfully created!");
        return "redirect:/ui/products" ;
    }

    @GetMapping("/ui/products/new")
    public String getNewProduct(Model model) {
        return "/ui/createProduct";
    }



    @GetMapping("/breakfasts")
    public String addToBreakfast(@PathVariable int id, Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Breakfast breakfast = restTemplate.getForObject("http://localhost:8081/breakfasts", Breakfast.class);
        model.addAttribute("breakfast", breakfast);
        return "/ui/home";
    }

}




