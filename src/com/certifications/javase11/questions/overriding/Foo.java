package src.com.certifications.javase11.questions.overriding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Foo {
    public void foo(Collection arg) {
        System.out.println("Bonjour le monde!");
    }
}

class Bar extends Foo {

    @Override
    public void foo(Collection arg) {
        System.out.println("Hello Word!");
    }

    public void foo(List arg) {
        System.out.println("Hola Mundo!!");
    }

    /*
    We can provide method overriding with parent and child class.
     */
    public void num(Integer num) {
        System.out.println(num*3);
    }

    public void num(Number num) {
        System.out.println(num.intValue()*2);
    }

}

class Test {
    public static void main(String[] args) {
        Foo f1 = new Foo();
        Foo f2 = new Bar();
        Bar b1 = new Bar();
        List<String> li = new ArrayList<>();

        b1.foo(li); // Hola Mundo!!
        f1.foo(li); // Bonjour le monde!

        //It will look for the implementation of foo() method in Foo, but as the implementation is of the Bar,
        // it will take precedence over the other.
        f2.foo(li); // Hello Word!

        Number num=6;
        b1.num(num);
    }
}
