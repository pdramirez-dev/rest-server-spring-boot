package com.pdramirez.restservice.employee;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import  java.util.Objects;


@Entity
public class Employee {
    private @Id
    @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String role;

    private String description;
    Employee() {
    }


    public Employee(String firstName, String lastName, String role, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName(){
        return this.firstName+" "+lastName;
    }

    public void setName(String name){
        String [] parts = name.split(" ");
        this.firstName=parts[0];
        this.lastName=parts[1];
    }

    public String getRole() {
        return role;
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

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;

        if (!Objects.equals(id, employee.id)) return false;
        if (!Objects.equals(firstName, employee.firstName)) return false;
        if (!Objects.equals(lastName, employee.lastName)) return false;
        return Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

