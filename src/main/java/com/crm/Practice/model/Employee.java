package com.crm.Practice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id  //it's for id to know database
    //here auto means auto increment, identity for unique value,sequences means it's belongs to list.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID; //hibernate convert this name to the sql format like emp_ID

    @Column //when we scan program it knows to create a column for this
    @NotNull //means this column can't be null
    @NotBlank
    private String firstName;

    @Column
    private String lastName;

    @Column
    @NotNull //means this column can't be null
    @NotBlank
    private String emailAddress;

    private Double salary;

    //mapping
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "dept_id", nullable = false)
    @JsonIgnore //with out it, it will give infinite loop of employee and department orders
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    //constructor for Employee class
    public Employee(){ //default constructor
    }

    public Employee(String firstName, String lastName, String emailAddress,Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.salary = salary;
    }

    //to get values
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    //Tostring method

    @Override
    public String toString() {
        return "Employee{" +
                "empID=" + ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", salary=" + salary +
                '}';
    }
}
