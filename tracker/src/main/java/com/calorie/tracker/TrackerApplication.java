package com.calorie.tracker;

import com.calorie.tracker.breakfast.Breakfast;
import com.calorie.tracker.breakfast.BreakfastRepository;
import com.calorie.tracker.product.Product;
import com.calorie.tracker.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TrackerApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private BreakfastRepository breakfastRepository;

	public static void main(String[] args) {SpringApplication.run(TrackerApplication.class, args);}

		@Override
	public void run(String... args) throws Exception {


		Product p1 = productRepository.findById(15);
		Breakfast b1 = breakfastRepository.findById(1);
		b1.addProduct(p1);
		this.productRepository.save(p1);
		this.breakfastRepository.save(b1);


//			productRepository.saveAll(
//					List.of(
//							new Product("Banana", 27, 1, 0, 150, 105)
////							new Product("Beef mince", 0, 31, 20, 100, 300),
////							new Product("Bread", 14, 3, 1, 300, 160)
//					)
//			);

		}
	}


