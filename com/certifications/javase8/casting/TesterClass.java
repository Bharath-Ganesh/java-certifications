package com.certifications.javase8.casting;

public class TesterClass {

    public static void main(String[] args) {
        TesterClass testerClass=new TesterClass();
        testerClass.testEmployee();
    }

    private void testEmployee() {
        Employee b=new Employee();
        b.setEmpId(20);
        System.out.println(b.getEmpId());

        Employee a=new Employee();
        System.out.println(a.getEmpId());
    }
}
