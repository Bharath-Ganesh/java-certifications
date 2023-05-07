package src.com.certifications.javase11.questions.ocpchap2.buildingblocks;

/*
A var is used as a local variable in a constructor, method, or initializer block.
A var cannot be used in constructor parameters, method parameters, instance variables, or class variables.
A var is always initialized on the same line (or statement) where it is declared.
The value of a var can change, but the type cannot.
A var cannot be initialized with a null value without a type.
A var is not permitted in a multiple-variable declaration.
A var is a reserved type name but not a reserved word, meaning it can be used as an identifier except as a class, interface, or enum name.
 */
public class VarDeclaration {

    public static float code;
    public static long code1;
    public static double code2;
    public static short code3;
    public static byte code4;
    public static char code5;

    int gills = 0;
    int fins = 0;

    {
        int fins=gills+2;
        System.out.println("Print: " + fins);
    }
    {
        System.out.println("setting field");
    }

    public static void main(String[] args) {
        VarDeclaration var=new VarDeclaration();
        System.out.println(code); // 0.0
        System.out.println(code1); // 0l
        System.out.println(code2); // 0.0
        System.out.println(code3); // 0
        System.out.println(code4); // 0
        System.out.println(code5); // \u0000
    }

    private void localVariables() {

        /*
        Option G is correct because local variables do not get assigned default values.
        The code fails to compile if a local variable is used when not being explicitly initialized.
         */
        float f1;
        boolean b1;
        int i1;
        double d1;
        Object o1;
    }
    //var is not a reserved word in Java.
    //You can only use this feature for local variables.
    //var tricky = "Hello"; // DOES NOT COMPILE

    public void whatTypeAmI() {
        // The formal name of this feature is local variable type inference.
        var name = "Hello";
        var size = 7;
    }

    public void reassignment() {
        var number = 7;
        number = 4;
        /*
        We have no trouble assigning a different int to it.
         We’ve asked it to assign a String to an int variable.
         Re-assigning the var variable is not possible
         */
        // number = "five";  // DOES NOT COMPILE

        short apples = (short) 10;
        /*
        The first line creates a var named apples with a type of short.
        It then assigns a byte of 5 to it, but did that change the data type of apples to byte? Nope!
         */
        apples = (byte) 5;

        /*
        The last line does not compile, as one million is well beyond the limits of short.
        The compiler treats the value as an int and reports an error indicating it cannot be assigned to apples.
         */
        // apples = 1_000_000;  // DOES NOT COMPILE
    }

    public void doesThisCompile(boolean check) {
        int a;
        a = 1;
        /*
        The code does not compile. Remember that for local variable type inference, the compiler looks only at the line with the declaration.
         Since question and answer are not assigned values on the lines where they are defined, the compiler does not know what to make of them.
         */

        //        var question;
        //        question = 1;
        //
        //        var answer;
        //        if (check) {
        //            answer = 2;
        //        }else{
        //            answer = 2;
        //        }
    }

    public void twoTypes() {
        // must be same type
        //int a, var b = 3;  // DOES NOT COMPILE

        //Java does not allow var in multiple variable declarations.
        //var a = 2, b = 3;  // DOES NOT COMPILE

        // it can't be assigned null
        //var n = null;      // DOES NOT COMPILE


        /*
        While a var cannot be initialized with a null value without a type, it can be assigned a null value after it is declared,
         provided that the underlying data type of the var is an object.
         */
        var n = "myData"; // Object
        n = null;
        var m = 4;
        // m = null;  // DOES NOT COMPILE

        // It compiles
        var o = (String) null;
    }

    // In this example, a and b are method parameters. These are not local variables
    //public int addition(var a, var b) {  // DOES NOT COMPILE
    //    return a + b;
    //}

    /*
    While var is not a reserved word and allowed to be used as an identifier, it is considered a reserved type name.
     A reserved type name means it cannot be used to define a type, such as a class, interface, or enum.
    public class var {  // DOES NOT COMPILE
        public var() {
    }
     */
}
