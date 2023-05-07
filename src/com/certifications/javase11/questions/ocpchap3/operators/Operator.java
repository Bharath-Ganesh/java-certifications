package src.com.certifications.javase11.questions.ocpchap3.operators;

public class Operator {

    public static void main(String[] args) {
        Operator obj = new Operator();
        // obj.compoundOperator();
        // obj.assignmentOperatorReturnValue();
        obj.test();
    }

    private void test() {
    /*
    . The cast (int) is applied to fruit, not the expression fruit+vegetables.
    Since the cast operator has a higher operator precedence than the addition operator, it is applied to fruit,
     but the expression is promoted to a float, due to vegetables being float.
    The result cannot be returned as long in the addCandy() method without a cast. For this reason, option F is correct.
     */
        // System.out.print(addCandy(1.4, 2.4f) + "-");
        //  System.out.print(addCandy(1.9, (float) 4) + "-");
        // System.out.print(addCandy((long) (int) (short) 2, (float) 4));


        long val1=2;
        long val2=4;
        float f1=12.3f;
        val2= (long) f1;

        /*
        increments pig by 1, but it returns the original value of 4 since it is using the post-increment operator.
         The pig variable is then assigned this value, and the increment operation is discarded.
         */
        int pig = (short)4;
        pig = pig++;
        System.out.println(pig); //4

        //Does not produce a compilation error since the compound operator applies casting automatically.
        long goat = (int)2;
        // Compound operator
        goat -= 1.0;
    }

    public void compoundOperator() {

        //We are trying to assign a long value to an int variable.
        //long goat = 10;
        //int sheep = 5;
        // sheep = sheep * goat;   // DOES NOT COMPILE

        /*
            Compound operators are useful for more than just shorthand—they can also save us from having to explicitly cast a value.
            The compound operator will first cast sheep to a long, apply the multiplication of two long values,
             and then cast the result to an int.
         */
        long goat = 10;
        int sheep = 5;
        sheep *= goat;
    }

    public void assignmentOperatorReturnValue() {
        long wolf = 5;
        /*
        The key here is that (wolf=3) does two things.
        First, it sets the value of the variable wolf to be 3.
        Second, it returns a value of the assignment, which is also 3.
         */
        long coyote = (wolf = 3);
        System.out.println(wolf);   // 3
        System.out.println(coyote); // 3

    /*
    While this may look like a test if healthy is true, it’s actually assigning healthy a value of true.
    The result of the assignment is the value of the assignment, which is true, resulting in this snippet printing Good!
     */
        boolean healthy = false;
        if (healthy = true)
            System.out.print("Good!");
        System.out.println(healthy);

    }

    public void instanceOfOperator(Number time) {
        //One area the exam might try to trip you up on is using instanceof with incompatible types.
        // For example, Number cannot possibly hold a String value, so the following would cause a compilation error:
        // if(time instanceof String) // DOES NOT COMPILE

        System.out.print(null == null);  // true

        System.out.print(null instanceof Object); // false

        /*
        The last example does not compile, since null is used on the right side of the instanceof operator:
         */
        //System.out.print(null instanceof null);  // DOES NOT COMPILE
    }

    //static long addCandy(double fruit, float vegetables) {
    //  return (int) fruit + vegetables;
    // }

}
