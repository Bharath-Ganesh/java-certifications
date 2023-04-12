package com.certifications.javase8.abstractAndNested;

public class TestNestedClass {

    public static void main(String[] args) {
        EmployeeNestedClass instance= new EmployeeNestedClass("Bharath");
        /**
         * Inner classes
         *
         * To instantiate an inner class, you must first instantiate the outer class. Then, create the inner object within the outer object with this syntax:
         *
         * OuterClass.InnerClass innerObject = outerObject.new InnerClass();
         */

        EmployeeNestedClass.HelperClass inst = new EmployeeNestedClass("Bharath").new HelperClass();
        instance.setType(TestEnum.EMPLOYEE);
        System.out.println(instance.getGuid());
        testEnum(instance.getType());

    }

    public static void testEnum(TestEnum e){
        System.out.println(e);
        System.out.println(e.getDescription());
    }
}
