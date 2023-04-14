package src.com.certifications.javase11.interfaces;

public interface Product {

    /**
     * The concrete methods in the child classes should be able to uniquely distinguish all the inherited methods
     * from the interfaces and extended classes.
     */
    public static String CEO = "Sundar pichai";

    /**
     * The methods are by default abstract and public
     */
    void buy();

    /**
     * The default methods are concrete methods that are possible in interfaces.
     *
     * @return
     */
    default String manager() {
        return "Inventory manager";
    }


    /**
     * public static methods are also available interfaces
     *
     * @return
     */
    private String getCeo() {
        return getCeoStatic();
    }

    public static String getCeoStatic() {
        return CEO;
    }


}
