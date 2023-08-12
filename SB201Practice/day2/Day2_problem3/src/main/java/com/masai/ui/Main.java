package com.masai.ui;

import java.util.Scanner;


import com.masai.dao.EmployeeDao;
import com.masai.dao.EmployeeDaoImpl;
import com.masai.dto.Employee;


public class Main {
	public static void main(String[] args) {
		  Scanner sc=new Scanner(System.in);  
		  EmployeeDao pd=new EmployeeDaoImpl();
		  int i=0;
		  do {
		    String banner="|******************************|\n"
		           +"|******************************|\n"
		           +"|****  Enter Your Choice ******|\n"
		           +"|******************************|\n"
		           +"|******************************|\n";
		   System.out.println(banner);
		   System.out.println("1. for Register Employee");
		   System.out.println("2. for Get Employee by id");
		   System.out.println("3. for delete employee");
		   System.out.println("4. for update Employee salary");
		   System.out.println("0. for Exit");
		   i=sc.nextInt();
		   switch(i)
		   {
		   case 1:
		    System.out.println("Enter Employee name");
		    String name=sc.next();
		    System.out.println("Enter address ");
		    String addres=sc.next();
		    System.out.println("Enter salary ");
		    int sal =sc.nextInt();
		    Employee emp=new Employee(name, addres, sal);
		    String ans=pd.registerEmployee(emp);
		    System.out.println(ans);
		   break;
		   
		   case 2:
		    System.out.println("Enter emp Id ");
		    int eid=sc.nextInt();
		    System.out.println(pd.getEmployeeById(eid));
		    break;
		    
		   case 3:
			   System.out.println("Enter emp Id ");
			     eid=sc.nextInt();
			    System.out.println(pd.deleteEmployeeById(eid));
			    break;
		   case 4:
			   System.out.println("Enter emp Id ");
			     eid=sc.nextInt();
		        System.out.println("Enter emp salary ");
			     int amount=sc.nextInt();
			    System.out.println(pd.updateEmployeeSalary(eid, amount));
			    break;
		   }
		   
		  }while(i!=0);
		 
		  System.out.println("done");
		 }
}
