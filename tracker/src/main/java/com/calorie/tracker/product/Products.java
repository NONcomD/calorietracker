package com.calorie.tracker.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Products {

    @NonNull
    private List<Product> products;

    public static Products of(List<Product> products){return new Products(products);}
}
