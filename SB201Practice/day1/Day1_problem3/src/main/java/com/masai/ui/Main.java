package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.CourtDAO;
import com.masai.dao.CourtDAOImp;
import com.masai.dto.Lawyer;


public class Main {
     public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("1. Find lawyer by Id \n2. Save Lawyer \n3. Delete lawyer by Id \n4. Update lawyer experience");
			System.out.print("Enter your selection ");
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				findLawyerByIdUI(sc);
				break;
			case 2:
				saveLawyerUI(sc);
				break;
			case 3:
				deleteLawyerByIdUI(sc);
				break;
			case 4:
				updateLawyerExperienceUI(sc);
				break;
			default:
				break;
			}
		}while(choice != 0);
	}

	private static void findLawyerByIdUI(Scanner sc) {
		System.out.print("Enter lawyer id ");
		int id = sc.nextInt();
		
		CourtDAO cDAO = new CourtDAOImp();
		Lawyer low = cDAO.findLawyerById(id);
		System.out.println("\n" + low + "\n");
	}

	private static void saveLawyerUI(Scanner sc) {
		System.out.print("Enter lawyer id ");
		int id = sc.nextInt();
		System.out.print("Enter name ");
		String name = sc.next();
		System.out.print("Enter email ");
		String email = sc.next();
		System.out.print("Enter address ");
		String address = sc.next();
		System.out.print("Enter experience ");
		int exp = sc.nextInt();
		
		Lawyer low = new Lawyer(id, name, email, address, exp);
		CourtDAO cDAO = new CourtDAOImp();
		String msg = cDAO.saveLawyer(low);
		System.out.println("\n" + msg + "\n");
	}

	private static void deleteLawyerByIdUI(Scanner sc) {
		System.out.print("Enter lawyer id ");
		int id = sc.nextInt();
		
		CourtDAO cDAO = new CourtDAOImp();
		String msg = cDAO.deleteLawyerById(id);
		System.out.println("\n" + msg + "\n");
	}

	private static void updateLawyerExperienceUI(Scanner sc) {
		System.out.print("Enter lawyer id ");
		int id = sc.nextInt();
		System.out.print("Enter experience ");
		int exp = sc.nextInt();
		
		CourtDAO cDAO = new CourtDAOImp();
		String msg = cDAO.updateLawyerExperience(id, exp);
		System.out.println("\n" + msg + "\n");
	}

	
}
