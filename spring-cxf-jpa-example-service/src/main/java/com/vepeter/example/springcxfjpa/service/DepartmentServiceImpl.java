package com.vepeter.example.springcxfjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.vepeter.example.springcxfjpa.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @PersistenceContext
    private EntityManager service;

    public List<Department> getAllDepartments() {
        List<Department> depts = service.createQuery("select d from Department d", Department.class).getResultList();
        return depts;
    }

    public void addDepartment(Department department) {
        service.persist(department);
    }
}
