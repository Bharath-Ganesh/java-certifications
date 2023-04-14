package src.com.certifications.javase11.chapter04classesAndStatic;

import java.time.Period;

public class StaticInitialization {


    public static Period defaultExpiryPeriod;

    /**
     * Globally visible constant
     * It's value is only read only being private
     */
    public static final Period defaultExpiryPeriod2 = Period.ofDays(3);
    public Period defaultExpiryPeriod3 = Period.ofDays(3);

    /**
     * Static Initializer runs once, before any other operation.
     * It's ran when classes are loaded.
     */
    static {
        defaultExpiryPeriod = Period.ofDays(3);
    }

    {
        defaultExpiryPeriod3 = Period.ofDays(4);
    }

    public static Period getDefaultExpiryPeriod() {
        return defaultExpiryPeriod;
    }

    public static void setDefaultExpiryPeriod(Period defaultExpiryPeriod) {
        StaticInitialization.defaultExpiryPeriod = defaultExpiryPeriod;
    }

    public static void main(String[] args) {
        StaticInitialization obj1 = new StaticInitialization();
        StaticInitialization obj2 = new StaticInitialization();
        obj1.setDefaultExpiryPeriod(Period.ofDays(4));
        System.out.println(obj1.getDefaultExpiryPeriod().getDays());
        System.out.println("Instance initializer : " +  obj1.defaultExpiryPeriod3.getDays());
        System.out.println("Instance initializer : " +  obj2.defaultExpiryPeriod3.getDays());


        /**
         * You can see that the static initialization assigned a Period value : 3
         * On re-assigning the period with a value 4 using the obj1 had also changed the value
         * for obj2; It shows static variable are class level variable not object level
         */
        System.out.println(obj2.getDefaultExpiryPeriod().getDays());
    }
}
