package ua.samoplavskaya.hw_patterns.StaticFactory_method;

import lombok.Data;

@Data
public class Order {
    private String product;
    private double price;
    private int quantity;
    private String info;
    private String deliveryAddress;


    private Order(String product, double price, int quantity, String info, String deliveryAddress) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.info = info;
        this.deliveryAddress = deliveryAddress;
    }


    public static Order of(String product, double price, int quantity, String info, String deliveryAddress) {
        if (product == null || product.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty or null");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be a positive value");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Stock must be a non-negative value");
        }
        return new Order(product, price, quantity, info, deliveryAddress);
    }

    public static Order getBasicOrder(String product, double price, int quantity) {
        if (product == null || product.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty or null");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be a positive value");
        }
        if (quantity < 0) {
            throw new IllegalArgumentException("Stock must be a non-negative value");
        }
        return new Order(product, price, quantity, "", "");
    }
}
