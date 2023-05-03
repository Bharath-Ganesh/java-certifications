package src.com.certifications.javase11.chapter15Annotation.target;

//Does not compile, because the annotation is applied to a class type.
//@ZooAttraction
public class RollerCoaster {
}

class Events {

    // It is permitted on a method declaration
    @ZooAttraction
    String rideTrain() {
        // Does not compile, because it is not permitted on a cast operation.
        // return (@ZooAttraction String) "Fun!";
        return "Fun!";
    }

    @ZooAttraction
        // The second annotation is not, as the annotation is not marked for use in a constructor parameter
    Events(/*@ZooAttraction */String description) {
        super();
    }

    // It cannot be applied to fields or variables.
    //@ZooAttraction
    int numPassengers;
}
