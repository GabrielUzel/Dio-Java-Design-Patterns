package com.dio.demo.factory;

import com.dio.demo.model.Product;

public class ProductFactory {
  public static Product createProduct(String name, Double price, String type) {
    Product product = new Product(name, price, type);
    return product;
  }
}
