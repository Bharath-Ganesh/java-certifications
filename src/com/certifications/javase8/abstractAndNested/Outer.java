package com.certifications.javase8.abstractAndNested;

// Java program to illustrate
// working of local inner classes
public class Outer
{
    /**
     *
     * Declaration within a method body
     */
    private void getValue()
    {
        // Note that local variable(sum) must be final till JDK 7
        // hence this code will work only in JDK 8
         int sum = 20;
         int a=5;

        // Local inner Class inside method
        class Inner
        {
            public int divisor;
            public int remainder;

            public Inner()
            {
                /**
                 * Note :- A local class can access local variables and parameters of the enclosing block that are effectively final.
                 * For example, if you add the highlighted assignment statement in the Inner class constructor or in any method of Inner class in above example :
                 */
               // sum=90;
                divisor = 4;
                remainder = sum%divisor;
            }
            private int getDivisor()
            {

                return divisor;
            }
            private int getRemainder()
            {
                return sum%divisor;
            }
            private int getQuotient()
            {
                System.out.println("Inside inner class");
                return sum / divisor;
            }
        }

        Inner inner = new Inner();
        System.out.println("Divisor = "+ inner.getDivisor());
        System.out.println("Remainder = " + inner.getRemainder());
        System.out.println("Quotient = " + inner.getQuotient());
    }

    public static void main(String[] args)
    {
        Outer outer = new Outer();
        outer.getValue();
    }
}
