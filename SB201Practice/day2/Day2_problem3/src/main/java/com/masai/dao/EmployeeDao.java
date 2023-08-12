package com.masai.dao;

import com.masai.dto.Employee;

public interface EmployeeDao {
	public String registerEmployee(Employee employee);
	
	public Employee getEmployeeById(int empId);
	
	public String deleteEmployeeById(int empId);
	
	public String updateEmployeeSalary(int empId, int amount);
}
