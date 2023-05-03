package src.com.certifications.javase11.chapter15Annotation.repeatable;

import java.lang.annotation.Repeatable;

/*
This code also does not compile, but this time because the @Repeatable annotation
 is not declared correctly. It requires a reference to a second annotation.
  That brings us to our next rule: to declare a @Repeatable annotation, you must define a containing annotation type value.

  A containing annotation type is a separate annotation that defines a value() array element.
  The type of this array is the particular annotation you want to repeat.

1. The repeatable annotation must be declared with @Repeatable and contain a value that refers to the containing type annotation.
2. The containing type annotation must include an element named value(), which is a primitive array of the repeatable annotation type.
 */
// @Repeatable()
@Repeatable(Risks.class)
@interface Risk {
    String danger();
    int level() default 1;
}

//Putting all of this together, the following Risks declaration is a containing annotation type for our Risk annotation:
@interface Risks {
    Risk[] value();
}


public class Zoo {
    public static class Monkey {}

    /*
    Does not compile. The Risk annotation is missing the @Repeatable annotation!
    Without the @Repeatable annotation, an annotation can be applied only once.
     So, let's add the @Repeatable annotation.
     */
    @Risk(danger="Silly")
    @Risk(danger="Aggressive",level=5)
    @Risk(danger="Violent",level=10)
    private Monkey monkey;
}