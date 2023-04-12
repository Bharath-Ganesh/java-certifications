package com.certifications.javase8.casting;

class Manager extends Employee {

    private Integer empId;
    private String empName;
    private String dept;

    public Manager(int empid, String empName, String dept) {
        this.empId = empid;
        this.empName = empName;
        this.dept = dept;
    }

    public void method() {
        System.out.println("Manager");

    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }


    public static void main(String[] args) {

        /**
         * Casting (Upcasting)
         */
        testUpCatsing();

        /**
         * Equal method and "==" Operator
         */
        equalComparsion();


        /**
         * Downcasting
         */
        testDownCasting();

    }


    /**
     * Casting
     */
    private static void testUpCatsing() {

        //  Up casting (Promotion )
        //  Here the Manager which is specific class is converted into a generic class
        Employee employee = new Employee(1, "Varshika");
        Manager manager = new Manager(2, "Rajeev", "ENG");
        System.out.println(employee.getClass());
        employee.method();
        manager.method();

        System.out.println("\n *** Virtual Invocation \n");
        // Virtual Invocation
        Employee employee1 = new Manager(3, "Renjith", "RCLADM");
        if (employee1 instanceof Manager) {
            Manager manager1 = (Manager) employee1;
            System.out.println(manager1.getDept());
        }


    }

    private static void testDownCasting() {
        /**
         * DownCasting
         *
         * Exception in thread "main" java.lang.ClassCastException: class com.certifications.javase8.casting.Employee cannot be cast to class com.certifications.javase8.casting.Manager (com.certifications.javase8.casting.Employee and com.certifications.javase8.casting.Manager are in unnamed module of loader 'app')
         * 	at com.certifications.javase8.casting.Manager.testUpCatsing(Manager.java:71)
         * 	at com.certifications.javase8.casting.Manager.main(Manager.java:35)
         */

        Manager manager2 = (Manager) new Employee(2, "Rajeev");
        manager2.getDept();
    }

    private static void equalComparsion() {

        System.out.println("\n\n*************Equal Comparison**********\n");

        /**
         * The equals method of object class do the comparison of actual reference
         * Since we are using new operator twice, two different instance of an object
         */
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        Employee emp3 = emp1;
        if (emp1.equals(emp2)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not equal");
        }

        String s1 = new String("TUTORIALSPOINT");
        String s2 = new String("TUTORIALSPOINT");

        System.out.println(s1 == s2);
        //Content comparison
        System.out.println(s1.equals(s2));

        System.out.println("Initializing strings without new Operator\n");
        /**
         *
         */
        String s3 = "TUTORIALSPOINT";
        String s4 = "TUTORIALSPOINT";

        System.out.println(s3 == s4);
        //Content comparison
        System.out.println(s3.equals(s4));
    }

}
