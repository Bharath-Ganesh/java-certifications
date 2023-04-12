package com.certifications.javase11.inheritance;

public abstract class Product {

    // private and abstract not a valid pair
    public abstract void serve();
    private int price;

    public Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
