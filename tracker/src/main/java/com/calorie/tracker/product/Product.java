package com.calorie.tracker.product;

import com.calorie.tracker.breakfast.Breakfast;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(exclude="breakfast")
@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    private String name;

    @NonNull
    private double carbs;

    @NonNull
    private double protein;

    @NonNull
    private double fat;

    @NonNull
    private double weight;

    @NonNull
    private double calories;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "breakfast_id", nullable = true)
    @ToString.Exclude
    private Breakfast breakfast;

    public void setBreakfast(Breakfast breakfast) {
        this.breakfast = breakfast;
    }


    // Getteriai, setteriai
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
