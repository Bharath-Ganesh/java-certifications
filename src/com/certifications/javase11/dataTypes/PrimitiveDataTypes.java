package com.certifications.javase11.dataTypes;

public class PrimitiveDataTypes {
    public static void main(String[] args) {

        /**
         * To initialize a float variable, a variable with decimal point, we need to provide f at the end.
         */
        float d = 1.2f;
        double dd = 1.2;


        int i = 1;
        long aa = 1l;

        /**
         * Math
         */
        int a = 11;
        int b = 3;
        int round = Math.round(a / b);
        System.out.println(round);


        double round2 = Math.round((double) a / b);
        System.out.println(round2);

        /**
         * To get the decimal points
         */
        double round3 = Math.round(((double) a / b) * 100)/100.0;
        System.out.println(round3);

        byte x1=2,x2=4,x3=8;
        /**
         * Lossy conversion
         * The addition of x1+x2 yields an int value.
         */
        x3=(byte) (x1+x2);

    }
}
