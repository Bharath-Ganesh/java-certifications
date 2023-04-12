package com.certifications.javase11.dataTypes;

public class FlowControlStatements {

    public static void main(String[] args) {

        // 1. Full evaluation
        // This will evaluate the expression irrespective of the left hand expression.
        int a = 2;
        int b = 2;
        if (a < b & ++b == 3) {
            System.out.println("Inside statement");
        }

        // Examine the following code:

        int x = 1, y = 1, z = 0;
        if (x == y | x < ++y) {
            z = x + y;
        } else {
            z = 1;
        }
        System.out.println(z);
    }
}
