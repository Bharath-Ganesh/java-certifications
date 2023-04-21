package src.com.certifications.javase11.chapter07interfaces;

import java.time.LocalDate;

public class Drink extends Food implements Product, Inventory {


    @Override
    public int getId() {
        return Product.super.getId();
    }

    public static void main(String[] args) {
        Drink drink=new Drink();
        // The parent class takes precedents over the interface methods
        LocalDate expiryDate = drink.getExpiryDate();
        System.out.println(expiryDate);

    }
}
