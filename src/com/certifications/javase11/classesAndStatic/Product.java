package com.certifications.javase11.classesAndStatic;

import java.math.BigDecimal;

public class Product {

    /**
     * final keywords has to be initialized at runtime or in all the constructors
     */
    private final Integer DISCOUNT_PERCENTAGE = 23;

    public static void main(String[] args) {
        Product p1 = new Product();
        System.out.println(p1.getPrice());
        final Integer discountPercentage = p1.getDiscountPercentage(6);
    }


    private BigDecimal price;


    public Integer getDiscountPercentage(final Integer percentage) {
        /**
         * final keyword cannot be re-assigned
         */
        //percentage=5;
        return percentage;
    }

    public BigDecimal getPrice() {

        /**
         * JAVA-10 feature
         *
         * It can only be used in for-loops and local variable
         * does not work with parameter values
         *
         * No need to explicitly declare local variable type.
         * It can be inferred from the assigned value
         */
        var value1 = "Hello";
        var value2 = 1l;
        var value3 = false;
        var value4 = "Hello World";

        // It's an error . Type cannot be re-assigned

        // value2=value4;

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price.intValue() == 0) {
            String dummyVariable = "No price is assigned"; // Here the dummyVariable can be only assigned within the curly braces scope
        }
        this.price = price;
    }
}
