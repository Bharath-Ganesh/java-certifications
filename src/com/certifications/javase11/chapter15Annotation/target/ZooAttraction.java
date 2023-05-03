package src.com.certifications.javase11.chapter15Annotation.target;

/*
ElementType value
Applies to


TYPE	Classes, interfaces, enums, annotations
FIELD	Instance and static variables, enum values
METHOD	Method declarations
PARAMETER	Constructor, method, and lambda parameters
CONSTRUCTOR	Constructor declarations
LOCAL_VARIABLE	Local variables
ANNOTATION_TYPE	Annotations


You can't add a package annotation to just any package declaration,
only those defined in a special file, which must be named package‐info.java.

PACKAGE *	Packages declared in package‐info.java


TYPE_PARAMETER *	Parameterized types, generic declarations

TYPE_USE	Able to be applied anywhere there is a Java type declared or used

MODULE *	Modules

 @Target annotation, which limits the types the annotation can be applied to.
 */


/*

 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.CONSTRUCTOR })
public @interface ZooAttraction {
}


@FunctionalInterface interface Scaley {
    boolean isSnake();
}

//Finally, the Smooth interface contains two abstract methods,
// although since one matches the signature of a method in java.lang.Object, it does compile.
@FunctionalInterface
interface Smooth extends Scaley {
    boolean equals(Object unused);
}
