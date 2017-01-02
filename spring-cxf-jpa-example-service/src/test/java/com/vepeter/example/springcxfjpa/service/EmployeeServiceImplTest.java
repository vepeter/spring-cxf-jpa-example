package com.vepeter.example.springcxfjpa.service;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.vepeter.example.springcxfjpa.model.Department;
import com.vepeter.example.springcxfjpa.model.Employee;
import com.vepeter.example.springcxfjpa.service.config.TestServiceConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestServiceConfiguration.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    @DatabaseSetup("EmployeeServiceImplTest-testGetAllEmployees.xml")
    public void testGetAllEmployees() {

        List<Employee> employees = employeeService.getAllEmployees();

        assertEquals(3, employees.size());

        Department expectedDepartment1 = new Department(1, "Department 1");
        Department expectedDepartment2 = new Department(2, "Department 2");

        Employee expectedEmployee1 = new Employee("User 1 First Name", expectedDepartment1);
        expectedEmployee1.setId(1);
        expectedEmployee1.setLastName("User 1 Last Name");
        expectedEmployee1.setEmail("user1@test.com");
        expectedEmployee1.setBirthDate(new LocalDate(1988, 11, 1));

        Employee expectedEmployee2 = new Employee("User 2 First Name", expectedDepartment1);
        expectedEmployee2.setId(2);
        expectedEmployee2.setLastName("User 2 Last Name");
        expectedEmployee2.setEmail("user2@test.com");
        expectedEmployee2.setBirthDate(new LocalDate(1988, 11, 2));

        Employee expectedEmployee3 = new Employee("User 3 First Name", expectedDepartment2);
        expectedEmployee3.setId(3);
        expectedEmployee3.setLastName("User 3 Last Name");
        expectedEmployee3.setEmail("user3@test.com");
        expectedEmployee3.setBirthDate(new LocalDate(1988, 11, 3));
        assertEquals(expectedEmployee1.getDepartment(), employees.get(0).getDepartment());

        assertEquals(Arrays.asList(expectedEmployee1, expectedEmployee2, expectedEmployee3), employees);
    }

}
