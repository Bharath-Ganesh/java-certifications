package src.com.certifications.javase11.chapter15Annotation.safeargs;

import java.util.*;

/*
@SafeVargs, the annotation is used to indicate to other developers that your method does not perform any unsafe operations.
It basically tells other developers, “Don't worry about the varargs parameter;
I promise this method won't do anything bad with it!” It also suppresses unchecked compiler warnings for the varargs parameter.
 */
public class NeverDoThis {

    /*
    We can remove both compiler warnings by adding the @SafeVarargs annotation.

     Type safety: Potential heap pollution via varargs parameter carrot

    It can be applied only to constructors or methods that cannot be overridden (aka methods marked private, static, or final).
    @SafeVarargs annotation can be applied only to methods that contain a varargs parameter and are not able to be overridden.
     */
    @SafeVarargs
    final int thisIsUnsafe(List<Integer>... carrot) {
        Object[] stick = carrot;
        stick[0] = Arrays.asList("nope!");
        return carrot[0].get(0);  // ClassCastException at runtime
    }

    // @SafeVarargs The eat() method is missing a varargs parameter,
    public static void eat(int meal) {
    }         // DOES NOT COMPILE

    //@SafeVarargs ;  methods are not marked static, final, or private.
    protected void drink(String... cup) {
    }      // DOES NOT COMPILE

    //@SafeVarargs   // DOES NOT COMPILE ; methods are not marked static, final, or private.
    void chew(boolean... food) {
    }

    public static void main(String[] a) {
        var carrot = new ArrayList<Integer>();
        //Type safety: A generic array of List<Integer> is created
        //   for a varargs parameter

        new NeverDoThis().thisIsUnsafe(carrot);
    }
}
