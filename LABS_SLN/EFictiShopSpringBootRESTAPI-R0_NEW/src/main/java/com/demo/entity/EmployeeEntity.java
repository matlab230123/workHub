package com.demo.entity;

import javax.persistence.*;

//Employee named as EmployeeModel for understanding Entities later.....
@Entity(name="EMPLOYEES")
public class EmployeeEntity {

    //AUTO_INCRMENT
    //SEQUENCE
    //TABLE
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "EMPLOYEE_ID")
    private  int id;
    @Column(name="FIRST_NAME")
    private String name;
    private int salary;

    public EmployeeEntity(){
    }
    public EmployeeEntity(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    @Override
    public String toString() {
        return "EmployeeModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}