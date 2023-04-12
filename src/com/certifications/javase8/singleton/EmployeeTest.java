package com.certifications.javase8.singleton;

class EmployeeTest {

    public static void main(String[] args) {
        Employee emp1=new Employee("Bharath");
        Employee emp2=new Employee("Karthik");

        System.out.println(emp1.getEmpName());
        System.out.println(emp1.getEmpId());
        emp1.setEmpId(1_20);

        System.out.println(emp2.getEmpName());
        System.out.println(emp1.getEmpId());
    }
}
