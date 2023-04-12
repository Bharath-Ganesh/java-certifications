package com.certifications.javase8.abstractAndNested;

public enum TestEnum {


    MANAGER("MANAGER and MANAGER"),
    EMPLOYEE("EMPLOYEE and EMPLOYEE");

    private String description;

    private TestEnum(String argument) {
        this.description = argument;
    }

    public String getDescription() {
        return description;
    }

}
