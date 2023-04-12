package com.certifications.javase8.singleton;

public class TestSingletonClass {

    public static void main(String[] args) {
        SingletonClass singletonClass1=SingletonClass.getInstance();
        SingletonClass singletonClass2=SingletonClass.getInstance();

        singletonClass1.setCounter(1);
        singletonClass2.setCounter(5);


        /**
         * The variable value is based on the class level
         */
        System.out.println(singletonClass1.getCounter());
        System.out.println(singletonClass2.getCounter());

        for(boolean values:singletonClass1.getSwitches()){
            System.out.println(values);
        }

        System.out.println("Different instance ");
        for(boolean values:singletonClass2.getSwitches()){
            System.out.println(values);
        }


    }
}
