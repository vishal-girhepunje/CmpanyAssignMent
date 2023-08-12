package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImp;
import com.masai.dto.Employee;
import com.masai.exception.EmployeeException;

public class Main {
     public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. Register Employee \n2. Show employee by id \n3. Show all employee \n4. Delete employee by id \n5. Give bonus to employee");
			System.out.print("Enter your selection ");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				registerEmployeeUI(sc);
				break;
			case 2:
				getEmployeeByIdUI(sc);
				break;
			case 3:
				getAllEmployeeUI();
				break;
			case 4:
				deleteEmployeeByIdUI(sc);
				break;
			case 5:
				giveBonusToEmployeeUI(sc);
				break;
			default:
				break;
			}
		}while(choice != 0);
	}

	private static void registerEmployeeUI(Scanner sc) {
		System.out.print("Enter employee id ");
		int id = sc.nextInt();
		System.out.print("Enter employee name ");
		String name = sc.next();
		System.out.print("Enter employee address ");
		String address = sc.next();
		System.out.print("Enter employee salary ");
		int salary = sc.nextInt();
		
		Employee emp = new Employee(id, name, address, salary);
		EmployeeDao empDao = new EmployeeDaoImp();
		
		String msg = empDao.registerEmployee(emp);
		System.out.println(msg);
	}

	private static void getEmployeeByIdUI(Scanner sc) {
		System.out.print("Enter employee id ");
	    int id = sc.nextInt();
	
		EmployeeDao empDao = new EmployeeDaoImp();
		try {
			Employee emp = empDao.getEmployeeById(id);
			System.out.println();
			System.out.println(emp);
			System.out.println();
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
	}

	private static void getAllEmployeeUI() {
		EmployeeDao empDao = new EmployeeDaoImp();
		List<Employee> list = empDao.getAllEmployee();
		System.out.println();
		list.forEach(t -> System.out.println(t));
		System.out.println();
	}

	private static void deleteEmployeeByIdUI(Scanner sc) {
		System.out.print("Enter employee id ");
	    int id = sc.nextInt();
	
		EmployeeDao empDao = new EmployeeDaoImp();
		try {
			String msg = empDao.deleteEmployeeById(id);
			System.out.println();
			System.out.println(msg);
			System.out.println();
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
	}

	private static void giveBonusToEmployeeUI(Scanner sc) {
		System.out.print("Enter employee id ");
		int id = sc.nextInt();
		System.out.print("Enter bonus ");
		int bonus = sc.nextInt();
		
		EmployeeDao empDao = new EmployeeDaoImp();
		try {
			String msg = empDao.giveBonusToEmployee(id, bonus);
			System.out.println();
			System.out.println(msg);
			System.out.println();
		} catch (EmployeeException e) {
			e.printStackTrace();
		}
	}
}
