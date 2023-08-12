package com.ui;

import java.util.Scanner;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.dto.Student;




public class Main {
	public static void main(String[] args) {
		  Scanner sc=new Scanner(System.in);
		//  
		  StudentDAO pd=new StudentDAOImpl();
		  
		  
		  int i=0;
		  do {
		    String banner="|******************************|\n"
		           +"|******************************|\n"
		           +"|****  Enter Your Choice ******|\n"
		           +"|******************************|\n"
		           +"|******************************|\n";
		   System.out.println(banner);
		   System.out.println("1. for Save Student");
		   System.out.println("2. for Find Student by Id");
		   System.out.println("3. for delete Student by Id");
		   System.out.println("4. for update Student Level");
		   System.out.println("0. for Exit");
		   i=sc.nextInt();
		   switch(i)
		   {
		   case 1:
		    System.out.println("Enter student email");
		    String email=sc.next();
		    System.out.println("Enter Student address ");
		    String addres=sc.next();
		    System.out.println("Enter student course");
		    String course=sc.next();
		    System.out.println("Enter student level");
		    int level =sc.nextInt();
		    Student stu=new Student(email, addres, course, level);
		    String ans=pd.saveStudent(stu);
		    System.out.println(ans);
		   break;
		   
		   case 2:
		    System.out.println("Enter Student Id ");
		    int eid=sc.nextInt();
		    System.out.println(pd.findStudentById(eid));
		    break;
		    
		   case 3:
			   System.out.println("Enter Studnet Id ");
			     eid=sc.nextInt();
			    System.out.println(pd.deleteStudentById(eid));
			    break;
		   case 4:
			   System.out.println("Enter Student Id ");
			     eid=sc.nextInt();
		        System.out.println("update student level ");
			     level=sc.nextInt();
			     pd=new StudentDAOImpl();
			    System.out.println(pd.updateStudentLevel(eid, level));
			    break;
		   }
		   
		  }while(i!=0);
		 
		  System.out.println("done");
		 }
}
