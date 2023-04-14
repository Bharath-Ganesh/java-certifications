package src.com.certifications.javase11.chapter02dataTypes;

public class TypeCasting {
    public static void main(String[] args) {

        System.out.println("Type casting");
        // 1. Type casting of short/byte/char to int datatype
        byte a = 3;
        byte b = 127;
        //a. here you can see the addition of two byte variables gets promoted to the int data type.
        int res1 = a + b;

        short c = 3;
        short d = 127;
        //b. here you can see the addition of two short variables are already promoted to the int data type
        int res2 = c + d;


        char e='a';
        char f='a';
        // c. here you can see the addition of two char variables are already promoted to the int data type
        // here the ascii value code get's incremented. 
        int res3 = e + f;
        System.out.println(res3);

        // 2. Explicit type casting
        System.out.println("\n\n Explicit type casting");
        // In the case of overflow, the additional result get's added to the maximum value of particular data type
        // maximum value of byte is 127;
        // 130-127 => 3;
        // -128 , -127 , -126
        byte b1 = (byte) (a + b);
        System.out.println(b1);

        byte b2 = (byte) (130);
        System.out.println(b2);

        // 3 Resulting type of arithmetic operations on type smaller than int is int;
        //Otherwise the result is of a type of largest participant

        byte num1 = 127;
        byte num2 = 3;
        int i = num1 / num2;
        float i1 = (float)(num1 / num2);
        System.out.println("\n\n i1 => "+i1);
        float i2 = ((float)num1 / num2);
        System.out.println(" i2 => "+ i2);
        float i3 = ((float)num1 / num2);
        System.out.println(" i3 => "+i3);
        // 4. No casting is required for increment and decrement operators
        byte b3 =3;
        byte b4 = b3++;


        char ch= (97);
        System.out.println(ch);

    }
}
