package com.certifications.javase8.abstractAndNested;

class EmployeeNestedClass {


    class HelperClass {
        private String guid;

        protected String calculateGuid() {
            guid = "guid" + empId;
            return guid;
        }
    }

    private static int empId = 100;
    private TestEnum type;

    private HelperClass helperClass = new HelperClass();

    protected String getGuid() {
        return helperClass.calculateGuid();
    }

    private String empName;

    public TestEnum getType() {
        return type;
    }

    public void setType(TestEnum type) {
        this.type = type;
    }

    public EmployeeNestedClass(String empName) {
        this.empName = empName;
        this.new HelperClass().calculateGuid();
    }

}
