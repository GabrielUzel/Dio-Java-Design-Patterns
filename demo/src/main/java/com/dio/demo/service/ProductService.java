package com.dio.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.dio.demo.repository.ProductRepository;
import com.dio.demo.service.discount.DigitalProductDiscount;
import com.dio.demo.service.discount.DiscountStrategy;
import com.dio.demo.service.discount.PhysicalProductDiscount;
import com.dio.demo.model.Product;
import com.dio.demo.factory.ProductFactory;
import java.util.List;

@Service
public class ProductService {
  @Autowired
  private ProductRepository repository;

  public Product createProduct(String name, Double price, String type) {
    Product product = ProductFactory.createProduct(name, price, type);
    return repository.save(product);
  }

  public Product getProduct(Long id) {
    return repository.findById(id).orElseThrow();
  }

  public List<Product> getAllProducts() {
    return repository.findAll();
  }

  public double getDiscountedPrice(Product product) {
    DiscountStrategy strategy;

    if ("physical".equals(product.getType())) {
      strategy = new PhysicalProductDiscount();
    } else {
      strategy = new DigitalProductDiscount();
    }
    
    return strategy.applyDiscount(product.getPrice());
  }
}
