package src.com.certifications.javase11.chapter15Annotation.valueof;

@Injured("Broken Tail")
public class Monkey {

}


abstract class Elephant {


    //The usage in the first two annotations are equivalent,
    // as the compiler will convert the shorthand form to the long form with the value() element name.

    @Injured("Legs") public void fallDown() {}

    @Injured(value="Legs") public abstract int trip();

    @Injured String injuries[];
}