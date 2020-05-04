package com.abhishek.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.springboot.entity.Product;
import com.abhishek.springboot.services.ProductJPARepository;

@RestController
public class ProductController {

	@Autowired
	private ProductJPARepository productService;
	
	@GetMapping("/welcome")
	public String sayHi() {
		return ("<h1>Welcome to Product page</h1>");
	}
	
	@GetMapping("/product")
	public Product getProduct() {
		Product myProduct = new Product(1,"A",20);
		return myProduct;
	}
	
	
	@GetMapping("/products")
	public List<Product> getProducts() {
//		List<Product> myProductList = new ArrayList<Product>();
//		
//		Product p1 = new Product(1,"A",20);
//		Product p2 = new Product(2,"B",30);
//		Product p3 = new Product(3,"C",70);
//		
//		myProductList.add(p1);
//		myProductList.add(p2);
//		myProductList.add(p3);
//		
//		
//		return myProductList;
		
		return productService.findAll();
	}
	
	
	@GetMapping("/products/{id}")
	public Product getProdByID(@PathVariable int id) {
		return productService.findById(id).get();
	}
	
	@DeleteMapping("/products/{id}")
	public String deleteProd(@PathVariable int id) {
		productService.deleteById(id);
		return "done";
	}
	
	@PostMapping("/products")
	public String addProd(@RequestBody Product product) {
		productService.save(product);
		return "OK";
	}
	
	
	
}
