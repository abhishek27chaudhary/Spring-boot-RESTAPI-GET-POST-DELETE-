package com.abhishek.springboot.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhishek.springboot.entity.Product;

public interface ProductJPARepository extends JpaRepository<Product, Integer> {

	
}
