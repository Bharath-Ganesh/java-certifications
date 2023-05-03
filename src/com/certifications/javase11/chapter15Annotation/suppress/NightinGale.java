package src.com.certifications.javase11.chapter15Annotation.suppress;

import java.util.*;

    /*
    "deprecation"	Ignore warnings related to types or methods marked with the @Deprecated annotation.
    "unchecked"	Ignore warnings related to the use of raw types, such as List instead of List<String>.
     */
class SongBird {

    @Deprecated
    static void sing(int volume) {
    }

    static Object chirp(List<String> data) {
        return data.size();
    }
}

/*
Enter @SuppressWarnings. Applying this annotation to a class, method, or type basically tells the compiler,
 “I know what I am doing; do not warn me about this.”
  it requires a String[] value() parameter.
 */
public class NightinGale {
    //The first warning is because we are using a method SongBird.sing() that is deprecated.

    /*
    Let's say we are absolutely sure that we don't want to change our Nightingale implementation, and we don't want the
    compiler to bother us anymore about these warnings.
    Adding the @SuppressWarnings annotation, with the correct values, accomplishes this.
     */
    @SuppressWarnings("deprecation")
    public void wakeUp() {
        SongBird.sing(10);
    }

    @SuppressWarnings("unchecked")
    public void goToBed() {
        SongBird.chirp(new ArrayList());
    }

    //The second warning is triggered by the call to new ArrayList(), which does not define a generic type.
    // An improved implementation would be to use new ArrayList<String>().
    public static void main(String[] args) {
        var birdy = new NightinGale();
        birdy.wakeUp();
        birdy.goToBed();
    }
}
