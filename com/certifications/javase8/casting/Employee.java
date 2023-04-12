package com.certifications.javase8.casting;

class Employee {

    private Integer empId;
    private String  empName;


    public void method() {
        System.out.println("Employee");
    }

    public Employee() {
    }

    public Employee(int empid,String empName) {
        this.empId = empid;
        this.empName=empName;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
