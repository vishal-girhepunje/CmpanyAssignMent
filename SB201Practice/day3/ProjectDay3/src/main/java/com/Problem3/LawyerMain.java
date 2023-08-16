package com.Problem3;

import java.util.Scanner;

import java.util.Scanner;

public class LawyerMain {
    public static void main(String[] args) {
        CourtDAO lawyer = new CourtDAOImpl();
        Scanner sc = new Scanner(System.in);
        int choice;
        Lawyer aLawyer; 
        do {
            String banner = "*  Enter Your Choice *";
            System.out.println(banner);
            System.out.println("1. for Save Lawyer");
            System.out.println("2. Get Lawyer by Id");
            System.out.println("3. Delete Lawyer by id ");
            System.out.println("4. update Lawyer Experience");
            System.out.println("0. Exit ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Lawyer name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Enter email ");
                    String email = sc.nextLine();
                    System.out.println("Enter Address"); 
                    String address = sc.nextLine();
                    System.out.println("Enter Experience");
                    int experience = sc.nextInt();
                    
                    // Create a new Lawyer object
                    aLawyer = new Lawyer(name, email, address, experience);
                    lawyer.saveLawyer(aLawyer);
                    break;

                case 2:
                    System.out.println("Enter Lawyer Id"); 
                    int id = sc.nextInt();
                    aLawyer = lawyer.findLawyerById(id); 
                    if (aLawyer != null) {
                        System.out.println(aLawyer);
                    } else {
                        System.out.println("Lawyer Not Found");
                    }
                    break;

                case 3:
                    System.out.println("Enter Lawyer Id");
                    id = sc.nextInt();
                    if (lawyer.deleteLawyerById(id)) {
                        System.out.println("Lawyer Deleted Successfully");
                    } else {
                        System.out.println("Lawyer Not Found");
                    }
                    break;       
                                      
                case 4:
                    System.out.println("Enter Lawyer Id");
                    id = sc.nextInt();
                    
                    System.out.print("Enter experience ");
                    int exp = sc.nextInt();
                    
                    CourtDAO cDAO = new CourtDAOImpl();
                    String msg = cDAO.updateLawyerExperience(id, exp);
                    System.out.println("\n" + msg + "\n");
                    break;
            }

        } while (choice != 0);
    }
}


