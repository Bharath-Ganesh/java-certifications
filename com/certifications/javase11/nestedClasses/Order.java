package com.certifications.javase11.nestedClasses;

import java.util.Random;

public class Order {

    private static int ORDER_ID = new Random().nextInt();
    private int orderId = ORDER_ID;


    public static Shipment createNewInstance(String shipment) {
        return new Shipment(shipment);
    }

    /**
     * The class is defined in the static context of the outer class.
     */
    private static class Shipment {

        String name;

        public Shipment(String shipment) {
            this.name = shipment;
        }
    }



    public static void main(String[] args) {
        Shipment shipment1 = Order.createNewInstance("Food");
        System.out.println(shipment1.name);
        Shipment shipment2 = Order.createNewInstance("Drinks");

        /**
         * It cannot be accessed outside the order class
         */
        Order.Shipment ship=new Order.Shipment("Shipment Order");
    }
}
