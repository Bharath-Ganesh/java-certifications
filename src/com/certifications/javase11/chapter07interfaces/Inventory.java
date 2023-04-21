package src.com.certifications.javase11.chapter07interfaces;

import java.util.Random;

public interface Inventory {

    public static int INVENTORY_DEFAULT_ID= new Random().nextInt(100);

    public default int  getId(){
        return INVENTORY_DEFAULT_ID;
    }

}
