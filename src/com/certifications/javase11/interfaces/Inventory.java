package src.com.certifications.javase11.interfaces;

public interface Inventory {

    public static String CEO="Satya Nadella";

    public default String manager(){
        return "Inventory manager";
    }
}
