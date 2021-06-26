package com.devsuperior.myfirstproject;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.myfirstproject.entities.Category;
import com.devsuperior.myfirstproject.entities.Product;
import com.devsuperior.myfirstproject.repositories.CategoryRepository;
import com.devsuperior.myfirstproject.repositories.ProductRepository;

@SpringBootApplication
public class MyfirstprojectApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyfirstprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Category eletronics = new Category(null, "Eletronics");
		Category books = new Category(null, "Books");
		
		Product tv = new Product(null,"TV", 2200.00, eletronics);
		Product domain = new Product(null,"Domain Driven Design", 120.00, books);
		Product ps5 = new Product(null,"PS5", 2800.00, eletronics);
		Product docker = new Product(null,"Docker", 100.00, books);
		
		eletronics.getProducts().addAll(Arrays.asList(tv, ps5));
		books.getProducts().addAll(Arrays.asList(domain, docker));
		
		categoryRepository.save(eletronics);
		categoryRepository.save(books);
		
		productRepository.save(tv);
		productRepository.save(domain);
		productRepository.save(ps5);
		productRepository.save(docker);
		
		
	}

}
