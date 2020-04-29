package com.crm.Practice.controller;

import com.crm.Practice.model.Department;
import com.crm.Practice.model.Employee;
import com.crm.Practice.repositories.DepartmentRepository;
import com.crm.Practice.repositories.EmployeeRepository;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class DepartmentController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/department")
    public List<Department> getAllDepartment() throws Exception {
        return departmentRepository.findAll();
    }

    @PostMapping("/department")
    public Department addDepartment( @Valid @RequestBody Department department) throws Exception{
            return departmentRepository.save(department);
    }

    @PutMapping("/department/{departmentId}")
    public Department editDepartment(@PathVariable(value = "departmentId") Long id, @Valid @RequestBody Department department) throws Exception{
        Optional<Department> oldDepartment = departmentRepository.findById(id);
        if(oldDepartment.isPresent()){
            oldDepartment.get().setEmployeeList(department.getEmployeeList());
            oldDepartment.get().setName(department.getName());
            oldDepartment.get().setArea(department.getArea());
            return departmentRepository.save(oldDepartment.get());
        }else{
                throw new Exception("Invalid");
        }
    }

    @DeleteMapping("/department/{departmentId}")
    public String  deleteDepartment (@PathVariable(value = "departmentId") Long id){
         departmentRepository.deleteById(id);
         return "deleted";
    }
}
