package src.com.certifications.javase11.chapter15Annotation.valueof;

/*
The annotation declaration must contain an element named value(), which may be optional or required.
The annotation declaration must not contain any other elements that are required.
The annotation usage must not provide values for any other elements.
 */
public @interface Injured {
    String veterinarian() default "unassigned";

    //This annotation is composed of multiple optional elements.
    // In this example, we gave value() a default value, but we could have also made it required.
    String value() default "foot";
    int age() default 1;
}


/*
BAD example

The first declaration contains two required elements, while the second annotation does not include an element named value().

public @interface Sleep {
   int value();
   String hours();
}

public @interface Wake {
   String hours();
}

@Injured("Fur",age=2) public class Bear {}  // DOES NOT COMPILE
 */