package com.certifications.javase8.abstractAndNested;

// Java program to demonstrate accessing
// a static nested class

// outer class
class OuterClass
{
    // static member
    static int outer_x = 10;

    // instance(non-static) member
    int outer_y = 20;

    // private member
    private static int outer_private = 30;

    // static nested class
    static class StaticNestedClass
    {
        void display()
        {
            // can access static member of outer class
            System.out.println("outer_x = " + outer_x);

            // can access display private static member of outer class
            System.out.println("outer_private = " + outer_private);

            // The following statement will give compilation error
            // as static nested class cannot directly access non-static members
            // System.out.println("outer_y = " + outer_y);

        }
    }
}

// Driver class

/**
 *
 In the case of normal or regular inner classes, without an outer class object existing, there cannot be an inner class object. i.e.,
 an object of the inner class is always strongly associated with an outer class object. But in the case of static nested class,
 Without an outer class object existing, there may be a static nested class object. i.e., an object of a static nested class is not
 strongly associated with the outer class object.

 As with class methods and variables, a static nested class is associated with its outer class. And like static class methods, a
 static nested class cannot refer directly to instance variables or methods defined in its enclosing class: it can use them only through an object reference.
 They are accessed using the enclosing class name.
 */
public class StaticNestedClassDemo
{
    public static void main(String[] args)
    {
        // accessing a static nested class
        OuterClass.StaticNestedClass nestedObject = new OuterClass.StaticNestedClass();

        nestedObject.display();

    }
}

