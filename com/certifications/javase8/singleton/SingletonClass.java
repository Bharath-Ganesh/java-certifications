package com.certifications.javase8.singleton;

public class SingletonClass {

    private static final SingletonClass instance = new SingletonClass();
    private int counter = 0;
    private static boolean[] switches = new boolean[2];

    private SingletonClass() {

    }

    public  int getCounter() {
        return counter;
    }

    public  void setCounter(int counter) {
        this.counter = counter;
    }

    /**
     * Static initializer block gets executed from top to down if you have multiple of them
     */
    static {
        for (int i = 0; i < 2; i++) {
            switches[i] = true;
        }
    }

    public boolean[] getSwitches() {
        return switches;
    }

    public static SingletonClass getInstance() {
        return instance;
    }
}
