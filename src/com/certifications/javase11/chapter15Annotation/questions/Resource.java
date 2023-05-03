package src.com.certifications.javase11.chapter15Annotation.questions;

public @interface Resource {
    String name();
    int priority() default 0;
}

//@Resource(priority = 100)                     DOES NOT COMPILE
//@Resource(priority = 0)                       DOES NOT COMPILE
//@Resource(name="Customer1",priority = 0)      COMPILE
// @Resource(name="Customer1")                  COMPILE
//@Resource()                                   DOES NOT COMPILE
class ProcessOrders{

}
