package src.com.certifications.javase11.chapter07interfaces.project.prod;

@FunctionalInterface
public interface Rateable<T> {

    //interfaces are allowed to create constants not variables

    public static final Rating DEFAULT_RATING = Rating.NOT_RATED;

    // 2. Add an abstract method to the Rateable interface.
    /*
        By default the methods in the interfaces are public and abstract; hence they're greyed out.
     */
    public abstract T applyRating(Rating rating);

    public default T applyRating(int stars){
        return applyRating(convert(stars));
    }

    // 3. Add default rating to the interface.
    /*
        The default methods are not abstract, hence the implementing classes don't need to override the method.
        Only three concrete methods are allowed in interface.
        1. Default methods
        2. Private methods
        3. static methods
     */
    public default Rating getRating(){
        return DEFAULT_RATING;
    }

    public static Rating convert(int stars){
        return (stars>=0 && stars<=5)? Rating.values()[stars]:DEFAULT_RATING;
    }
}
