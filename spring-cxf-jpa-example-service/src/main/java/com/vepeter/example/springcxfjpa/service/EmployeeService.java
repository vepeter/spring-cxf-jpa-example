package com.vepeter.example.springcxfjpa.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vepeter.example.springcxfjpa.model.Employee;

@Transactional
public interface EmployeeService {

    List<Employee> getAllEmployees();

    void addEmployee(Employee employee);
}
