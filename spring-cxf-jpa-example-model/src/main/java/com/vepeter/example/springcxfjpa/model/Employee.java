package com.vepeter.example.springcxfjpa.model;

import java.io.Serializable;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vepeter.example.springcxfjpa.model.converter.LocalDateAttributeConverter;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty
    private String firstName;

    private String lastName;

    private String email;

    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate birthDate;

    @NotNull
    @ManyToOne
    private Department department;

    public Employee() {
        super();
    }

    public Employee(String name, Department department) {
        super();
        this.firstName = name;
        this.department = department;
    }

    public Employee(String name) {
        this.firstName = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).append(id).append(firstName).append(lastName).append(email).append(birthDate)
                .append(department).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Employee rhs = (Employee) obj;
        return new EqualsBuilder().append(id, rhs.id).append(firstName, rhs.firstName).append(lastName, rhs.lastName)
                .append(email, rhs.email).append(birthDate, rhs.birthDate).append(department, rhs.department)
                .isEquals();
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", birthDate=" + birthDate + ", department=" + department + "]";
    }

}