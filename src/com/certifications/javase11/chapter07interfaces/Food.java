package src.com.certifications.javase11.chapter07interfaces;

import java.time.LocalDate;
import java.util.Random;

public class Food {

    public static int DEFAULT_ID = new Random().nextInt(10);

    public static LocalDate EXPIRY_DATE = LocalDate.now();


    public LocalDate getExpiryDate() {
        return EXPIRY_DATE;

    }
}
