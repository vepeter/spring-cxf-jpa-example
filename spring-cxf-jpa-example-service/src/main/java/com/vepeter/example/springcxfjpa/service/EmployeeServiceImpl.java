package com.vepeter.example.springcxfjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.vepeter.example.springcxfjpa.model.Department;
import com.vepeter.example.springcxfjpa.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @PersistenceContext
    private EntityManager service;

    public List<Employee> getAllEmployees() {
        List<Employee> employees = service.createQuery("select e from Employee e", Employee.class).getResultList();
        return employees;
    }

    private Department getDepartmentById(Integer id) {
        return service.find(Department.class, id);
    }

    public void addEmployee(Employee employee) {
        // Use null checks and handle them
        employee.setDepartment(getDepartmentById(employee.getDepartment().getId()));
        service.persist(employee);
    }
}
