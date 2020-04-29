package com.crm.Practice.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Department")
public class Department {

    //we can give annotation to the constructor,
    // @Autowired use setter method, field injection

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depId;

    @NotNull
    private String name;


    private String Area;



    //mapping
    //one to many
    //fetch type.Eager is bulky. it loads application
    //cascade is verify or to ensure whenever we are doing delete operation
    @OneToMany(mappedBy = "department" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Employee> employeeList = new HashSet<>();


    public Set<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Set<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Department(){
    }

    public Department(String name, String area) {
        this.name = name;
        Area = area;

    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String area) {
        Area = area;
    }
//
//    public Long getID() {
//        return ID;
//    }
//
//    public void setID(Long ID) {
//        this.ID = ID;
//    }


    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", name='" + name + '\'' +
                ", Area='" + Area + '\'' +
                ", empId=" +
                '}';
    }
}

//for creating spring bean
//class level{
//    String Developer;
//    String workLevel;
//    String experience;
//}

/*
* in main function
* level lev = new level("FrontEnd", "Intern", "0-1");
* Department dep = new Department ("123", add) */// here add means pass this level in here inside this controller