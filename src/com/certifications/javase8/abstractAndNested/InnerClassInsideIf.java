package com.certifications.javase8.abstractAndNested;

// Java program to illustrate Declaration of
// local inner classes inside an if statement
public class InnerClassInsideIf
{
    public int data = 10;
    public int getData()
    {
        return data;
    }
    public static void main(String[] args)
    {
        InnerClassInsideIf outer = new InnerClassInsideIf();

        if(outer.getData() < 20)
        {
            // Local inner class inside if clause
            class Inner
            {
                public int getValue()
                {
                    System.out.println("Inside Inner class");
                    return outer.data;
                }
            }

            Inner inner = new Inner();
            System.out.println(inner.getValue());
        }
        else
        {
            System.out.println("Inside Outer class");
        }
    }
}


