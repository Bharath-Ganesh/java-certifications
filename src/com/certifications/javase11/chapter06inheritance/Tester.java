package src.com.certifications.javase11.chapter06inheritance;

public class Tester {

    public static void main(String[] args) {
        /**
         * When the superclass; product has a custom constructor; all the subclass
         * needs to invoke the superclass constructor;
         *
         * By default, there will be no-args constructor.
         *
         */
        Product p1=new Food(2,"Chicken");
        System.out.println("Food Price " + p1.getPrice());
        Food f1=new Food(2,"Chicken");
        Drink d1=new Drink(2,3);
        System.out.println("Drink Price " + d1.getPrice());

        Product p2=new Drink(3,4);
        Product p3=f1;
        Drink d2=(Drink) p2;
        /**
         * It's a runtime error
         */
        //Drink d3=(Drink) p3;
        //System.out.println(d3.getBestBefore());

        /**
         * Final class
         * The biriyani classes cannot be further extended
         */
        Food b=new Biriyani(5,"Biriyani");

    }
}
