package src.com.certifications.javase11.chapter07interfaces;

import java.time.LocalDate;
import java.util.Random;

public interface Product {

    public static int DEFAULT_ID= new Random().nextInt(10);

    public static LocalDate DEFAULT_DATE= LocalDate.now().plusDays(2);

    public default int  getId(){
        return DEFAULT_ID;
    }


    default LocalDate  getExpiryDate(){
        return DEFAULT_DATE;
    }

}
