package com.Problem1;

import java.util.Scanner;

public class EmpUI {
	public static void main(String[] args) {
	EmployeeDao employee=new EmployeeDaoImpl();
	Scanner sc=new Scanner(System.in);
	int i=0;
	do {
		   String greeting="*  Enter Your Choice *";
				System.out.println(greeting);
				System.out.println("1. for Svae Employee");
				System.out.println("2. Get employee Address");
				System.out.println("3. Give Bonus");
				System.out.println("4. Delete Employee ");
				System.out.println("0. Exit ");
				i=sc.nextInt();
				switch(i) {
				case 1: 
					System.out.println("Enter Employee name: ");
					sc.nextLine();
					String name=sc.nextLine();
					System.out.println("Enter Address ");
					String address=sc.nextLine();
					System.out.println("Enter Salary");
					int salary=sc.nextInt();
					employee.save(new Employee(name, address, salary));
					break;
				case 3:
					System.out.println("Enter Employee Id");
					int empId=sc.nextInt();
					System.out.println("Enter Amount ");
					int amount =sc.nextInt();
					System.out.println(employee.giveBonusToEmployee(empId, amount));
					break;

				case 2:
					System.out.println("Enter Employee Id");
					empId=sc.nextInt();
					System.out.println( employee.getAddressOfEmployee(empId));
					 break;

				case 4:
					System.out.println("Enter Employee Id");
					empId=sc.nextInt();
					 if(employee.deleteEmployee(empId)){
						 System.out.println("Employee Deleted Sucessfully");
					 }else {
						 System.out.println("Employee Not found ");
					 }
					 break;
				}
	}while(i!=0);
}
}
