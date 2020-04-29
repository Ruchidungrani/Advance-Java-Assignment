package com.crm.Practice.repositories;

import com.crm.Practice.model.Department;
import com.crm.Practice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
//         List<Department> FindByEmployeeList(Employee employee);
}
