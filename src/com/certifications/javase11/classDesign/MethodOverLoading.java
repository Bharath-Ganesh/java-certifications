package com.certifications.javase11.classDesign;

public class MethodOverLoading {

    public MethodOverLoading(String name){

    }


    /**
     * Variable arguments
     *  public static void main(String... args) {
     *  Instead of square bracket we can use this.
     * @param args
     */
    public static void main(String... args) {

        /**
         * The no-args constructor gets implicitly added to the class,
         * only if no other constructors are added.
         *
         * In the above case, we have a constructor with a single argument, hence the default constructor
         * won't be present. That's the reason for the below failure
         */
        //MethodOverLoading obj=new MethodOverLoading();
    }


}
