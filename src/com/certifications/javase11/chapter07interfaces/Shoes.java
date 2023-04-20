package src.com.certifications.javase11.chapter07interfaces;

public class Shoes extends Shop implements Product, Inventory {

    @Override
    public void buy() {

    }

    /**
     * The manager method needs to be overrided in the child class
     * 1. The inventory and product interfaces were having the same method manager(default methdods).
     * 2. To remove the conflict, the child class must override the method manager.
     *
     * @return
     */
    @Override
    public String manager() {
        return Inventory.super.manager();
    }



    public static void main(String[] args) {
        Shoes shoes=new Shoes();
        // the default methods can be inherited
        shoes.manager();
    }
}
