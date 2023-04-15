package src.com.certifications.javase11.chapter04classesAndStatic;

import java.time.Period;

public class StaticInitialization {


    public static Period staticDefaultExpiryPeriod;

    /*
     * 1. Globally visible constant
     * It's value is only read only being private
     * Encapsulation is not required as it's read only.
     */
    public static final Period defaultExpiryPeriod2 = Period.ofDays(3);


    /*
     * 2. Static Initializer runs once, before any other operation.
     * It's ran when classes are loaded.
     */
    static {
        staticDefaultExpiryPeriod = Period.ofDays(3);
    }


    public static Period getDefaultExpiryPeriod() {
        return staticDefaultExpiryPeriod;
    }

    public static void setDefaultExpiryPeriod(Integer days) {
        StaticInitialization.staticDefaultExpiryPeriod = Period.ofDays(days);
    }

    public static void main(String[] args) {
        StaticInitialization.setDefaultExpiryPeriod(4);
        StaticInitialization obj1 = new StaticInitialization();
        StaticInitialization obj2 = new StaticInitialization();
        obj1.setDefaultExpiryPeriod(2); //2
        System.out.println(obj2.getDefaultExpiryPeriod().getDays()); // 2
        StaticInitialization obj3 = new StaticInitialization();
        System.out.println(obj3.getDefaultExpiryPeriod().getDays()); //2
        System.out.println(obj1.getDefaultExpiryPeriod().getDays()); //2
    }
}
