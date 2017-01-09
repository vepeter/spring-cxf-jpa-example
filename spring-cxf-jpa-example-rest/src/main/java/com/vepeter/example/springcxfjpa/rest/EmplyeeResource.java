package com.vepeter.example.springcxfjpa.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vepeter.example.springcxfjpa.model.Employee;
import com.vepeter.example.springcxfjpa.service.EmployeeService;

@Component
public class EmplyeeResource {

    private EmployeeService employeeService;

    @Autowired
    public EmplyeeResource(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @GET
    @Produces("application/json")
    public Response listEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return Response.ok(employees).build();
    }

    @POST
    @Consumes("application/json")
    public Response createEmplyee(Employee employee, @Context UriInfo uriInfo) {
        employeeService.addEmployee(employee);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(employee.getId()));
        return Response.created(builder.build()).build();
    }

}
