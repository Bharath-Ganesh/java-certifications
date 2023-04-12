package com.certifications.javase11.inheritance;

public class Food extends Product {

    private String name;

    public Food(int price, String name) {
        super(price);
        this.name = name;
    }

    @Override
    public void serve() {
        //
        System.out.println("Serve in a plate");
    }

    @Override
    /**
     * Method overloading
     * Override annotation is optional;
     * It make sure to check whether we have a getPrice method with same signature in the super class
     * You can't narrow down the access modifier in the subclasses.
     */
    public int getPrice() {
        return super.getPrice() * 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
