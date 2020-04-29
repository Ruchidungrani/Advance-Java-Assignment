package com.crm.Practice.controller;

import java.util.*;

import com.crm.Practice.model.Department;
import com.crm.Practice.model.Employee;
import com.crm.Practice.repositories.DepartmentRepository;
import com.crm.Practice.repositories.EmployeeRepository;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    //CRUD Operation it's put in term of HTTP
    //1. create =  post
    //2. read = get
    //3. update  = put
    //4. delete = delete

    //for take request
    @GetMapping("/department/{departmentId}/employee")
    public List<Employee> getAllEmployee (@PathVariable (value = "departmentId") Long id){

//        return employeeRepository.findAll();
        Optional<Department> department =departmentRepository.findById(id);
        return employeeRepository.findByDepartment(department.get());
    }


    @RequestMapping(value = "/department/{departmentId}/employee", method = RequestMethod.POST )
    public Employee addEmployee(@PathVariable(value = "departmentId") Long id, @Valid @RequestBody Employee employee) throws Exception{
        Optional <Department> department = departmentRepository.findById(id);
        if(department.isPresent()){
            employee.setDepartment(department.get());
            return employeeRepository.save(employee);
        }else{
            throw new Exception("Invalid");
        }
    }


    @PutMapping("/department/{departmentId}/employee/{employeeId}")
    public Employee editEmployee (@PathVariable (value = "departmentId") Long departmentId,
                                    @PathVariable (value = "employeeId") Long employeeId,
                                        @Valid @RequestBody Employee employee)throws  Exception{
        Optional<Employee> oldEmployee  = employeeRepository.findById(employeeId);
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(department.isPresent()){
            if(oldEmployee.isPresent()) {
                oldEmployee.get().setFirstName(employee.getFirstName());
                oldEmployee.get().setLastName(employee.getLastName());
                oldEmployee.get().setEmailAddress(employee.getEmailAddress());
                oldEmployee.get().setSalary(employee.getSalary());
                return employeeRepository.save(oldEmployee.get());
            }else{
                throw new Exception(("Invalid"));
            }
        }else{
            throw new Exception(("Invalid"));
        }
    }

    @DeleteMapping("/department/{departmentId}/employee/{employeeId}")
    public String deleteEmployee (@PathVariable (value = "departmentId") Long departmentId,
                                  @PathVariable (value = "employeeId") Long employeeId){
        Optional<Department> department = departmentRepository.findById(departmentId);
        Optional<Employee> employee  = employeeRepository.findById(employeeId);
        if(department.isPresent()){
            if(employee.isPresent()){
                employeeRepository.deleteById(employeeId);
                return "Deleted";
            }else{
                return "Employee Not deleted";
            }
        }else{
            return " Department not found - not deleted";
        }
    }
}

//Spring Beans
//Dispatcher Servlet
//DI: Dependency Injection
//Database Connectivity
