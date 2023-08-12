package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.Employee;
import com.masai.exception.EmployeeException;
import com.masai.utils.DBUtils;


public class EmployeeDaoImp implements EmployeeDao {

	public String registerEmployee(Employee emp) {
		String msg = "Unable to register employee";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "insert into employee values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, emp.getEmpId());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getAddress());
			ps.setInt(4, emp.getSalary());
			
			if(ps.executeUpdate() > 0) msg = "Employee register successfully";
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}

	public Employee getEmployeeById(int empId) throws EmployeeException {
		Employee emp = null;
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "select * from employee where empId = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, empId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				emp = new Employee(empId, rs.getString(2), rs.getString(3), rs.getInt(4));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return emp;
	}

	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<>();
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "select * from employee";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

	public String deleteEmployeeById(int empId) throws EmployeeException {
		String msg = "Unable to delete employee";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "delete from employee where empId = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, empId);
			
			if(ps.executeUpdate() > 0) msg = "Employee deleted successfully";
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}

	public String giveBonusToEmployee(int empId, int amount) throws EmployeeException {
		String msg = "Unable to give bonus to employee";
		Connection con = null;
		try {
			con = DBUtils.getConnectionToDatabases();
			String query = "update employee set salary = salary + ? where empId = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, amount);
			ps.setInt(2, empId);
			
			if(ps.executeUpdate() > 0) msg = "Bonus give to employee successfully";
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}
}
