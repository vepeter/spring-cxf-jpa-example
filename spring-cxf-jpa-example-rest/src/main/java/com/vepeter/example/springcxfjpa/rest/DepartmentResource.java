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

import com.vepeter.example.springcxfjpa.model.Department;
import com.vepeter.example.springcxfjpa.service.DepartmentService;

@Component
public class DepartmentResource {
    
    private DepartmentService departmentService;

    @Autowired
    public DepartmentResource(DepartmentService departmentService) {
        super();
        this.departmentService = departmentService;
    }

    @GET
    @Produces("application/json")
    public Response listDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return Response.ok(departments).build();
    }

    @POST
    @Consumes("application/json")
    public Response createDepartment(Department department, @Context UriInfo uriInfo) {
        departmentService.addDepartment(department);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(department.getId()));
        return Response.created(builder.build()).build();
    }

}
