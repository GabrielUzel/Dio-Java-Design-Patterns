package com.dio.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  private String name;
  private Double price;
  private String type;

  public Product(String name, Double price, String type) {
    this.name = name;
    this.price = price;
    this.type = type;
  }

  public double getPrice() {
    return this.price;
  }

  public String getType() {
    return this.type;
  }
}
