package src.com.certifications.javase11.chapter04classesAndStatic;

import java.util.List;

public class VariableInitialization {

    public static void main(String[] args) {

        /*
         * JAVA-10 feature
         *
         * Local variable type inference
         *
         * 1. It can only be used in
         * a. for-loops and
         * b. local variable with initializer (It has to be initialized)
         * c. Local variables in traditional for loops
         *
         *
         * No need to explicitly declare local variable type.
         * It can be inferred from the assigned value
         */

        //1. Initializers
        // It's not a keyword, it's a special identifier.
        var value1 = "Hello";
        var value2 = 1l;
        var value3 = false;
        var value4 = "Hello World";

        // 2. Using enhanced loops
        List<Integer> list = List.of(1, 2, 3, 4);
        for(var val : list){
            System.out.println(val);
        }

        // 3. Using
        for(var a=0;a<list.size();a++){
            System.out.println(list.get(a));
        }
        // It's an error . Type cannot be re-assigned

        // value2=value4;

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
    }
}
