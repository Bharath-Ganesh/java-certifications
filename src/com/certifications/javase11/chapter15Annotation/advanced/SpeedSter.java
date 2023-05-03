package src.com.certifications.javase11.chapter15Annotation.advanced;

@FunctionalInterface
interface Speedster {
    void go(String name);
}

// The following compiles, assuming the annotations referenced in it exist:

/*
    Classes, interfaces, enums, and modules
    Variables ( static, instance, local)
    Methods and constructors
    Method, constructor, and lambda parameters
    Cast expressions
    Other annotations
 */


//@LongEars
//@Soft
//@Cuddly // Annotation applied to a class
//public class Rabbit {


//    @Deprecated // Annotation applied to a constructor
      // Annotation applied to a parameter
//    public Rabbit(@NotNull Integer size) {
//    }
//
//    @Speed(velocity = "fast")
//    public void eat(@Edible String input) {

          // Annotation applied to a parameter

//When applying an annotation to an expression, a cast operation including the Java type is required.
// The expression was cast to String, and the annotation @Tasty was applied to the type.
//        @Food(vegetarian = true) String m = (@Tasty String) "carrots";
//
//        Speedster s1 = new @Racer Speedster() {
//            public void go(@FirstName @NotEmpty String name) {
//                System.out.print("Start! " + name);
//            }
//        };
//
//        Speedster s2 = (@Valid String n) -> System.out.print(n);
//    }
//}
