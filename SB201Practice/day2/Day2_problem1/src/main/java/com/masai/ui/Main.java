package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.ProductDao;
import com.masai.dao.ProductDaoImpl;
import com.masai.dto.Product;

public class Main {
	public static void main(String[] args) {
		  Scanner sc=new Scanner(System.in);
		//  
		  ProductDao pd=new ProductDaoImpl();
		  
		  
		  int i=0;
		  do {
		    String banner="|******************************|\n"
		           +"|******************************|\n"
		           +"|****  Enter Your Choice ******|\n"
		           +"|******************************|\n"
		           +"|******************************|\n";
		   System.out.println(banner);
		   System.out.println("1. for Insert new Product");
		   System.out.println("2. Product find by id");
		   i=sc.nextInt();
		   switch(i)
		   {
		   case 1:
		    System.out.println("Enter product name");
		    String productName=sc.next();
		    System.out.println("Enter Quantity ");
		    int quantity=sc.nextInt();
		    System.out.println("Enter the price ");
		    int price =sc.nextInt();
		    Product pro=new Product( productName, quantity, price);
		    pd.update(pro);
		   break;
		   
		   case 2:
		    System.out.println("Enter Product Id ");
		    int pid=sc.nextInt();
		    System.out.println(pd.findProduct(pid));
		    
		   }
		   
		  }while(i!=0);
		 
		  System.out.println("added successfullly !");
		 }
}
