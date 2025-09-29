package com.dio.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dio.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  
}
