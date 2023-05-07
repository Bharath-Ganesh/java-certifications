package src.com.certifications.javase11.chapter15Annotation.questions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface AuthorInfo {

    String author() default "";

    String date();

    String[] comments() default {};
}

// Class level annotation not possible
// @AuthorInfo(date = "1-1-2020");
public class Test {

    // @AuthorInfo() ; date is a required value
    public void fun1() {

    }

    @AuthorInfo(date = "1-1-2020", author = "Gandi", comments = { "Word" })
    public void fun2() {

    }

    @AuthorInfo(date = "1-1-2020", comments = "Word")
    public void fun3() {

    }
}
