package src.com.certifications.javase11.chapter15Annotation.advanced;

import src.com.certifications.javase11.chapter15Annotation.advanced.Exercise;

class Bear {

}

enum Size {
    SMALL, MEDIUM, LARGE
}

public @interface Panda {
    // Primitive types like int and long are supported, wrapper classes like Integer and Long are not.
    //Integer height();
    int height();

    // The type String[] is supported, as it is an array of String values, but String[][] is not.
    // String[][] generalInfo();
    String[] generalInfo();

    Size size() default Size.SMALL;

    //Finally, the friendlyBear() element does not compile.
    // The type of friendlyBear() is Bear (not Class). Even if Bear were changed to an interface, the friendlyBear()
    //Bear friendlyBear();

    // Remember, this is the only way to create an annotation value.
    // Unlike instantiating a class, the new keyword is never used to create an annotation.
    Exercise exercise() default @Exercise(hoursPerDay = 2);

    //Like abstract interface methods, annotation elements are implicitly abstract and public, whether you declare them that way or not.
    // private String friendly();      // DOES NOT COMPILE

    // It cannot be marked final.
    //final boolean isBunny();        // DOES NOT COMPILE



}

/*
The default value of an annotation cannot be just any value. Similar to case statement values,
    the default value of an annotation must be a non‐ null constant expression.

public @interface BadAnnotation {
    String name() default new String("");  // DOES NOT COMPILE
    String address() default "";
    String title() default null;           // DOES NOT COMPILE
}
 */