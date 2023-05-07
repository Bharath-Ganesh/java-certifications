package src.com.certifications.javase11.questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Foo {

    public List<Integer> foo(Set<CharSequence> m) {
        return new ArrayList<>();
    }

    public List<Integer> num1(int a) {
        return null;
    }






}

class Foo1<V> {
    public static void main(String[] args) {

        Foo1<Object> object = new Foo1<>();
        // Ambiguous call
        object.bar(new A());
        object.bar(new B());

        CharSequence obj=new StringBuffer("123123");
        System.out.println(obj);

    }

    public void bar(A value) {
    }

    public void bar(B value) {
    }

}

class A {
    int id;
}

class B extends A {

    int id;

}




