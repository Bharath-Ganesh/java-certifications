package src.com.certifications.javase11.chapter03localDateTimeAndWrapper;

public class WrapperClasses {

    public static void main(String[] args) {
        int a=23;
        /*
         * auto boxing
         * Here we are creating a wrapper box of Integer type around the primitive variable a
         * It accepts both string and int value.
         */
        Integer b=Integer.valueOf(a);
        /*
         * auto-unboxing
         */
        int c = b.intValue();

        //Here the conversion of variable a to the wrapper class of type Integer, hence it's auto boxing
        b=a; // auto-boxing
        c=b; // un-boxing




        //Create wrapper or primitive out of the string
        String num="23";
        int i = Integer.parseInt(num);
        
        
        // Primitive to string
        Integer val=50;
        String.valueOf(val);


    }
}
