package src.com.certifications.javase11.chapter05classDesign;

public class MethodOverLoading {

    /*
     * Variable arguments
     * public static void main(String... args) {
     * Instead of square bracket we can use this.
     */
    public static void main(String... args) {
        MethodOverLoading obj1 = new MethodOverLoading();
        long res1 = obj1.addition(2, 3);
        long res2 = obj1.addition(2, 3, 4);
        long res3 = obj1.addition(2l, 3l);
        double res4 = obj1.addition(2.2, 3);
    }

    /*
    Method overloading in java is a feature that allows a class to have more than one method with the same name, but with different parameters.

    1. By changing the number of parameters
    2. By changing the data type of parameters overloading by changing the number of parameters A method can be overloaded by changing the number of parameters.
    3. Different order of parameters
     */


    private long addition(int a, int b) {
        return a + b;
    }

    /*
    Method overloading has nothing to do with return-type.
If there are two methods of the same signature within a class in the program, then Ambiguity Error comes, whether their return-type is different or not.
This means that method overloading has no relation with return-type.
     */
    // 3. Different order of parameters
    private double addition(double a, int b) {
        return a + b;
    }

    // 1. By changing the number of parameters
    private long addition(int a, int b, int c) {
        return a + b;
    }

    //2. By changing the data type of parameters
    private long addition(long a, long b) {
        return a + b;
    }


}
