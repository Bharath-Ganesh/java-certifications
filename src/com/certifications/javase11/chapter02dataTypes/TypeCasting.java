package src.com.certifications.javase11.chapter02dataTypes;

public class TypeCasting {
    public static void main(String[] args) {

        //float value
        float fVal=12.999E3f;
        System.out.println(fVal); //12999.0

        System.out.println("Type casting");
        // 1. Type casting of short/byte/char to int datatype
        byte a = 3;
        byte b = 127;
        //a. here you can see the addition of two byte variables gets promoted to the int data type.
        int res1 = a + b; // 130


        short c = 3;
        short d = 127;  // 130
        //b. here you can see the addition of two short variables are already promoted to the int data type
        int res2 = c + d;


        char e='g';
        char f='d';
        // c. here you can see the addition of two char variables are already promoted to the int data type
        // here the ascii value code get's incremented.
        char val=(char)97;
        System.out.println("VAL:" + val);
        char res3 = (char)('a' + (e - f));
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
        System.out.println("\n\n i1 => "+i1); //42.0
        float i2 = ((float)num1 / num2);
        System.out.println(" i2 => "+ i2); //42.333332
        float i3 = ((float)num1 / num2);
        System.out.println(" i3 => "+i3); //42.333332
        // 4. No casting is required for increment and decrement operators
        byte b3 =3;
        byte b4 = b3++;


        char ch= (97);
        System.out.println(ch);


        // Math.round()
        // Math.round() return an int value
        // It has to be explicitly multiplied and divided to convert into an
        int round = Math.round(23 / 3);
        System.out.println(round); // 7

        float round2 = Math.round( ((float) 23 / 3)*100)/100f; //7.67
        System.out.println(round2);


        // Short circuit evaluation
        int a1=3 , a2=2;
        boolean valB=false;

        valB= (a1>a2 && ++a2==3); // valB:true ; a2=3
        valB= (a1>a2 & ++a2==3);  // valB:true ; a2=4
        valB= (a1>a2 || ++a2==3); // valB:false ; a2=5
        valB= (a1>a2 | ++a2==3); //  valB:false ; a2=6
        System.out.println(valB);
        System.out.println(a2);

        // Look at the decimal precision
        byte x=2, y=3, z=5;

        float aa=(float) x/y;
        System.out.println(aa); // 0.6666667

        double dd= (double)x/y; // 0.6666666666666666
        System.out.println(dd);

        dd =aa;
        System.out.println(dd); // 0.6666666865348816
        // Here we can see the rounding problem, and to solve use Math.round()

        // character literal ,  ASCII character code and unicode
        char cc='a', c2='\141', c3='\u0061';
        System.out.println(cc);
        System.out.println(c2);
        System.out.println(c3);

        int cc1=cc;
        System.out.println(Integer.toOctalString(cc1));
        System.out.println(Integer.toHexString(cc1));
    }
}
