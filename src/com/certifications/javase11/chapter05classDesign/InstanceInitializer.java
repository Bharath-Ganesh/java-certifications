package src.com.certifications.javase11.chapter05classDesign;

import java.util.Random;

public class InstanceInitializer {

    private static Integer SCHOOL_ID;

    private Integer studentId;

    //static initializer
    // This is triggered once, during the class load.
    static {
        SCHOOL_ID = 100;
    }

    // instance initializer
    // It's executed every time an object is created
    {
        studentId = new Random().nextInt(5);
    }

    public static Integer getSchoolId() {
        return SCHOOL_ID;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public static void main(String[] args) {
        InstanceInitializer obj1 = new InstanceInitializer();
        InstanceInitializer obj2 = new InstanceInitializer();

        System.out.println(obj1.getStudentId());
        System.out.println(obj1.getSchoolId());


        System.out.println(obj2.getStudentId());
        System.out.println(obj2.getSchoolId());

    }
}
