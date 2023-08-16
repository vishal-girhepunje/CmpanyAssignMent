package com.Problem1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String name;
	private String adress;
	private int salary;
	public Employee() {}
	public Employee(int empId, String name, String adress, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.adress = adress;
		this.salary = salary;
	}
	
	public Employee(String name, String adress, int salary) {
		super();
		this.name = name;
		this.adress = adress;
		this.salary = salary;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", adress=" + adress + ", salary=" + salary + "]";
	}
	
}
