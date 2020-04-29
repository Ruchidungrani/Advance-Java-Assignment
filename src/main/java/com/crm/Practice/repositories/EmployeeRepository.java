package com.crm.Practice.repositories;

import com.crm.Practice.model.Department;
import com.crm.Practice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository //to Identify it's repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public List<Employee> findByDepartment(Department department);
}

//Define the REST controller

