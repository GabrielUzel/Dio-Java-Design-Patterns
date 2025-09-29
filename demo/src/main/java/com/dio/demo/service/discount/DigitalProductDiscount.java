package com.dio.demo.service.discount;

public class DigitalProductDiscount implements DiscountStrategy {
  @Override
  public double applyDiscount(double price) {
    return price * 0.90;
  }
}
