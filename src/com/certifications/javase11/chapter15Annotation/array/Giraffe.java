package src.com.certifications.javase11.chapter15Annotation.array;

public class Giraffe {

    //The first annotation is considered the regular form, as it is clear the usage is for an array
    @Music(genres={"Rock and roll"}) String mostDisliked;

    // The second annotation is the shorthand notation, where the array braces ( {}) are dropped for convenience.
    @Music(genres="Classical") String favorite;

    //The first provides more than one value
   // @Music(genres="Blues","Jazz") String newFavourite;  // DOES NOT COMPILE

    //while the next two do not provide any values.
   // @Music(genres=) String mostDisliked;            // DOES NOT COMPILE
   // @Music(genres=null) String other;               // DOES NOT COMPILE

    // The last one does compile, as an array with no elements is still a valid array.
    @Music(genres={}) String alternate;



}
