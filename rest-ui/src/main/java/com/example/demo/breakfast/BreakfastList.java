package com.example.demo.breakfast;


import com.example.demo.Product.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class BreakfastList {

    @NonNull
    private List<Product> products;

    public static BreakfastList of(List<Product> breakfast){return new BreakfastList(breakfast);}
}
