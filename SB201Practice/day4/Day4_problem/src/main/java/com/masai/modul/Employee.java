package com.masai.modul;

import javax.persistence.*;

@Entity
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Find All Employee",
                query = "select * from Employee", resultClass = Employee.class
        ),
        @NamedNativeQuery(
                name = "Find Employee By Name",
                query = "select * from Employee where name = ?", resultClass = Employee.class
        )
})
public class Employee {
    @Id
    private int empId;
    private String name;
    private String address;
    private int salary;
    private String email;

    public Employee() {
    }

    public Employee(int empId, String name, String address, int salary, String email) {
        this.empId = empId;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.email = email;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", email='" + email + '\'' +
                '}';
    }
}
