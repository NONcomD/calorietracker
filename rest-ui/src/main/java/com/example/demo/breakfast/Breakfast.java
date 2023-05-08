package com.example.demo.breakfast;


import com.example.demo.Product.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "breakfast")

public class Breakfast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int breakfastId;

    @ManyToOne
    @JoinColumn(name = "id")
    @NonNull
    private Product product;

    @NonNull
    private LocalDateTime createdAt;

    public int getBreakfastId() {
        return breakfastId;
    }

    public void setBreakfastId(int breakfastId) {
        this.breakfastId = breakfastId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
