package src.com.certifications.javase11.inheritance;

import src.com.certifications.javase11.inheritance.*;

public class Drink extends Product {
    private int bestBefore;

    public Drink(int price, int bestBefore) {
        super(price);
        this.bestBefore = bestBefore;
    }

    @Override
    public void serve() {
        System.out.println("Pour in a glass");
    }

    @Override
    public int getPrice() {
        return super.getPrice() * 5;
    }

    public int getBestBefore() {
        return bestBefore;
    }

    public void setBestBefore(int bestBefore) {
        this.bestBefore = bestBefore;
    }
}
