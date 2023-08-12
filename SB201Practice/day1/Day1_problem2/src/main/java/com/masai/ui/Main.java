package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.StudentDao;
import com.masai.dao.StudentDaoImp;
import com.masai.dto.Student;
import com.masai.exception.StudentException;


public class Main {
     public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. Show student by roll no \n2. Show all student \n3. Sava student details \n4. Delete student by roll no \n5. Grace Student Marks \n6. Show student by name");
			System.out.print("Enter your selection ");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				getStudentByRollNoUI(sc);
				break;
			case 2:
				getAllStudentUI();
				break;
			case 3:
				saveStudentDetailsUI(sc);
				break;
			case 4:
				deleteStudentByRollNoUI(sc);
				break;
			case 5:
				graceStudentMarksUI(sc);
				break;
			case 6:
				getStudentsByNameUI(sc);
				break;
			default:
				break;
			}
		}while(choice != 0);
	}

	private static void getStudentByRollNoUI(Scanner sc) {
		System.out.print("Enter student roll no ");
		int rollNo = sc.nextInt();
		
		StudentDao stuDao = new StudentDaoImp();
		try {
			Student stu = stuDao.getStudentByRollNo(rollNo);
			System.out.println("\n" + stu + "\n");
		} catch (StudentException e) {
			e.printStackTrace();
		}
	}

	private static void getAllStudentUI() {
		StudentDao stuDao = new StudentDaoImp();
		List<Student> list = stuDao.getAllStudent();
		System.out.println();
		list.forEach(t -> System.out.println(t));
		System.out.println();
	}

	private static void saveStudentDetailsUI(Scanner sc) {
		System.out.print("Enter student roll no ");
		int rollNo = sc.nextInt();
		System.out.print("Enter student name ");
		String name = sc.next();
		System.out.print("Enter student address ");
		String address = sc.next();
		System.out.print("Enter student marks ");
		int marks= sc.nextInt();
		
		Student str = new Student(rollNo, name, address, marks);
		StudentDao stuDao = new StudentDaoImp();
		String msg = stuDao.saveStudentDetails(str);
		System.out.println("\n" + msg + "\n");
	}

	private static void deleteStudentByRollNoUI(Scanner sc) {
		System.out.print("Enter student roll no ");
		int rollNo = sc.nextInt();
		
		StudentDao stuDao = new StudentDaoImp();
		try {
			boolean flag = stuDao.deleteStudentByRollNo(rollNo);
			System.out.println(flag==true ? "\nStudent deleted successfully\n" : "\nUnable to delete student\n");
		} catch (StudentException e) {
			e.printStackTrace();
		}
	}

	private static void graceStudentMarksUI(Scanner sc) {
		System.out.print("Enter student roll no ");
		int rollNo = sc.nextInt();
		System.out.print("Enter student marks ");
		int marks= sc.nextInt();
		
		StudentDao stuDao = new StudentDaoImp();
		try {
			String msg = stuDao.graceStudentMarks(rollNo, marks);
			System.out.println("\n" + msg + "\n");
		} catch (StudentException e) {
			e.printStackTrace();
		}
	}

	private static void getStudentsByNameUI(Scanner sc) {
		System.out.print("Enter student name ");
		String name = sc.next();
		
		StudentDao stuDao = new StudentDaoImp();
		try {
			List<Student> list = stuDao.getStudentsByName(name);
			System.out.println();
			list.forEach(t -> System.out.println(t));
			System.out.println();
		} catch (StudentException e) {
			e.printStackTrace();
		}
	}
}
