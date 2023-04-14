package src.com.certifications.javase11.chapter03localDateTimeAndWrapper;

public class StringInternings {

    public static void main(String[] args) {

        //How to initialize a String
        //1. Using double quotes
        String teaTxt="tea";

        //2
        String b="tea";

        //Because of automatic string internment, only one copy of a string object with a value of "tea"
        //has been placed in memory and both of the variable (teaText and b) are referencing the same object
        boolean isTeaTxtValueEqualToB=teaTxt==b;
        System.out.println(isTeaTxtValueEqualToB); //true

        //3. Using new Operator
        String c=new String("tea");

        // Coz creating a new operator to create string object is discouraged as this will prevent auto string
        //internment.
        boolean areTheySameObject=c==teaTxt;
        System.out.println(areTheySameObject); //false


        //4
        c.intern();
        System.out.println(c==teaTxt); //false


        //5
        // Intern method simply returns a reference to the existing copy of "tea"
        //obj that is already referenced by teaText and b
        String d=c.intern();
        System.out.println(d==teaTxt); //true


        /**
         * String concatenation
         */
        c=teaTxt+" " + b;
        System.out.println(c);

        // c= "tea tea"
        int t = c.indexOf('t');
        System.out.println(t); //0

        int lastIndex = c.lastIndexOf('t');
        System.out.println(lastIndex); //4

        /**
         * StringBuilder
         * // They're not thread safe
         */
        StringBuilder text=new StringBuilder(c);

        System.out.println(text.length()); //7 //Length amount of characters
        System.out.println(text.capacity());//23 //Size of internal storage

        StringBuilder what_is_the_price_of = text.replace(0, 3, "What is the price of");
        System.out.println(what_is_the_price_of); // What is the price of tea
    }
}
