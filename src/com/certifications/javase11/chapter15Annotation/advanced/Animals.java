package src.com.certifications.javase11.chapter15Annotation.advanced;

public class Animals {

    //@Exercise(hoursPerDay=3)
    // public class Cheetah {}

    // The Sloth class does not compile because it is missing parentheses around the annotation parameters
    // @Exercise hoursPerDay=0   // DOES NOT COMPILE
    //public class Sloth {}

    // This class does not compile because the hoursPerDay field is required
    // When declaring an annotation, any element without a default value is considered required.
    // @Exercise  // DOES NOT COMPILE
    // public class ZooEmployee {}

    //Providing an Optional Element

    @Exercise(startHour = 5, hoursPerDay = 3)
    public class Cheetah {
    }

    //We also see that Sloth does not specify a value for startHour, meaning it will be instantiated with the default value of 6.
    @Exercise(hoursPerDay = 0)
    public class Sloth {
    }

    //First, when we have more than one element value within an annotation, we separate them by a comma ( ,).
    // Next, each element is written using the syntax elementName = elementValue.
    /*
    In this version, the ZooEmployee class does not compile because it defines a value that is incompatible with the int type of startHour.
    The compiler is doing its duty validating the type!
     */
    //@Exercise(hoursPerDay=7, startHour="8")  // DOES NOT COMPILE

    @Exercise(hoursPerDay = 7, startHour = 8)
    public class ZooEmployee {
    }

    // Does not compile since MAX_VOLTAGE is a constant, not an element, and cannot be included in an annotation
    // @Exercise(hoursPerDay=7, startHour=8,MAX_VOLTAGE=1)
    public class Duck {
    }
}


