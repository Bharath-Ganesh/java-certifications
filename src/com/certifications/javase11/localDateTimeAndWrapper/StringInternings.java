package src.com.certifications.javase11.localDateTimeAndWrapper;

public class StringInternings {

    public static void main(String[] args) {

        //How to initialize a String
        //1. Using double quotes
        String a="2";

        //2. Using new Operator
        String b=new String("2");


        boolean isAValueEqualToB=a.equals(b);
        System.out.println(isAValueEqualToB);

        boolean areTheySameObject=a==b;
        System.out.println(areTheySameObject);

        //3. String interning
        /**
         * When the intern method is invoked, if the pool already contains a string equal to this String object as determined
         * by the equals(Object) method, then the string from the pool is returned.
         * Otherwise, this String object is added to the pool and a reference to this String object is returned.
         */
        String c=a.intern();
        String d=b.intern();


        boolean isCValueEqualToD=c.equals(d);
        System.out.println(isCValueEqualToD);

        boolean are_C_and_D_TheySameObject=c==d;
        System.out.println(are_C_and_D_TheySameObject);

        /**
         * The initial capacity of String Builder is 16.
         * This will not create an immutable object.
         */
        StringBuilder newBuilder=new StringBuilder();


    }
}
