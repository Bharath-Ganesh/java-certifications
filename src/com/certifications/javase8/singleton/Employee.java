package com.certifications.javase8.singleton;

class Employee {

    private static int empId = 100;

    private String empName;
    public Employee(String empName){
        this.empName=empName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        Employee.empId = empId;
    }
}
