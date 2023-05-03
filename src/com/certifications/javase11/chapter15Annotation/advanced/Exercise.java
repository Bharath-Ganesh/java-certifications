package src.com.certifications.javase11.chapter15Annotation.advanced;


//let's change @Exercise from a marker annotation to one that includes an element.
public @interface Exercise {

    //  An element or attribute
    // Behind the scenes, the JVM is creating elements as interface methods and annotations as implementations of these interfaces.
    int hoursPerDay();

    //Providing an Optional Element
    int startHour() default 6;

    // Adding a Constant Variable
    // Annotation variables are implicitly public, static, and final
    public static final int MAX_VOLTAGE = 18;
}





