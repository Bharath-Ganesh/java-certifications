package src.com.certifications.javase11.chapter04classesAndStatic;

public class VariableInitialization {

    public static void main(String[] args) {

        /**
         * JAVA-10 feature
         *
         * It can only be used in for-loops and local variable
         * does not work with parameter values
         *
         * No need to explicitly declare local variable type.
         * It can be inferred from the assigned value
         */
        var value1 = "Hello";
        var value2 = 1l;
        var value3 = false;
        var value4 = "Hello World";

        // It's an error . Type cannot be re-assigned

        // value2=value4;

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
    }
}
