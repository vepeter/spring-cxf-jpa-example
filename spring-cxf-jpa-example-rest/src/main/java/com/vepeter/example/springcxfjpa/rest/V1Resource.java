package com.vepeter.example.springcxfjpa.rest;

import javax.ws.rs.Path;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class V1Resource {

    private EmplyeeResource emplyeeResource;

    private DepartmentResource departmentResource;

    @Autowired
    public V1Resource(EmplyeeResource emplyeeResource, DepartmentResource departmentResource) {
        super();
        this.emplyeeResource = emplyeeResource;
        this.departmentResource = departmentResource;
    }

    @Path("/employees")
    public EmplyeeResource employees(@Context ResourceContext resourceContext) {
        return resourceContext.initResource(emplyeeResource);
    }

    @Path("/departments")
    public DepartmentResource departments(@Context ResourceContext resourceContext) {
        return resourceContext.initResource(departmentResource);
    }

}
