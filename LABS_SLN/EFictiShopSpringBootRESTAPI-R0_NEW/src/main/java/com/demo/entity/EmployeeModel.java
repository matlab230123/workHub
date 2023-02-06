package com.demo.entity;

public class EmployeeModel {

    private String name;

    private int salary;

    public EmployeeModel() {

    }
    public EmployeeModel(int id, String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
