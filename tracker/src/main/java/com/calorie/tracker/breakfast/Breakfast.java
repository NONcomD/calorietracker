package com.calorie.tracker.breakfast;

import com.calorie.tracker.product.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@Table(name = "breakfast")

public class Breakfast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int breakfastId;

//    @OneToMany
//    @JoinColumn(name = "id")
//    @NonNull
//    private Product product;

    @OneToMany(mappedBy = "breakfast",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet();

    public void addProduct(Product product){
        products.add(product);
        product.setBreakfast(this);
    }

    public String userName;


//    @NonNull
//    private LocalDateTime createdAt;





    // Getters/setters
//    public int getBreakfastId() {
//        return breakfastId;
//    }
//
//    public void setBreakfastId(int breakfastId) {
//        this.breakfastId = breakfastId;
//    }

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }

    public void setProduct(Product product) {
    }
}
