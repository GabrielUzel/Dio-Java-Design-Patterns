package com.dio.demo.service.discount;

public class PhysicalProductDiscount implements DiscountStrategy {
  @Override
  public double applyDiscount(double price) {
    return price * 0.95; 
  }
}