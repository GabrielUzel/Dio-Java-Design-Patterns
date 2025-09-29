package com.dio.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.dio.demo.service.ProductService;
import com.dio.demo.model.Product;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService service;

  @PostMapping
  public Product create(
    @RequestParam String name, 
    @RequestParam Double price, 
    @RequestParam String type
  ) {
    return service.createProduct(name, price, type);
  }

  @GetMapping("/{id}")
  public Product get(@PathVariable Long id) {
    return service.getProduct(id);
  }

  @GetMapping
  public List<Product> list() {
    return service.getAllProducts();
  }

  @GetMapping("/{id}/discounted")
  public double getDiscountedPrice(@PathVariable Long id) {
    Product product = service.getProduct(id);
    return service.getDiscountedPrice(product);
  }
}
