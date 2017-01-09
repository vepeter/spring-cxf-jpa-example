package com.vepeter.example.springcxfjpa.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.vepeter.example.springcxfjpa.model.Department;

@Transactional
public interface DepartmentService {

    List<Department> getAllDepartments();

    void addDepartment(Department employee);
}
