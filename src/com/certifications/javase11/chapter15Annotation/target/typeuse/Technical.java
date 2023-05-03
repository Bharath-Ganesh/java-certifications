package src.com.certifications.javase11.chapter15Annotation.target.typeuse;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*

@Documented
Then the generated Javadoc will include annotation information defined on Java types.
Because it is a marker annotation, it doesn't take any values; therefore, using it is pretty easy.

In this example, the @Technical  annotation would be published with the NetworkRepair
Javadoc information because it's marked with the @Documented annotation.


@Retention(RetentionPolicy.RUNTIME)
RetentionPolicy value
Description
SOURCE	Used only in the source file, discarded by the compiler
CLASS	Stored in the .class file but not available at runtime (default compiler behavior)
RUNTIME	Stored in the .class file and available at runtime


@Target(ElementType.TYPE_USE)
There are a few exceptions; for example, it can be used only on a method that returns a value.
Methods that return void would still need the METHOD value defined in the annotation.

It also allows annotations in places where types are used,
 1. such as cast operations,
 2. object creation with new,
 3. inside type declarations, etc.
 */
@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface Technical {

}
