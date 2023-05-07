package src.com.certifications.javase11.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class Bar extends Foo {

    //both methods have same erasure, yet neither overrides the other
    /*
        1. public List<Number> foo(Set<String> m) {...}
            both methods have same erasure, yet neither overrides the other
        2. public List<Integer> foo(Set<CharSequence> m) {...}
            Works
        3. public List<Integer> foo(TreeSet<String> m) {...}
            Works
        4. public List<Object> foo(Set<CharSequence> m)
            attempting to use incompatible return type
        5. public ArrayList<Integer> foo(Set<String> m)
            both methods have same erasure, yet neither overrides the other
        6. public ArrayList<Number> foo(Set<CharSequence> m)
            attempting to use incompatible return type

     */
    @Override
    public ArrayList<Integer> foo(Set<CharSequence> m) {
        return null;
    }



    public ArrayList<Integer> num1(int a) {
        return null;
    }

    public static void main(String[] args) {
        Bar obj=new Bar();

    }
}
