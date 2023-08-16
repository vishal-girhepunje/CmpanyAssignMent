package com.Problem2;

import java.sql.Timestamp;
import java.util.Scanner;

public class BookUi {
	public static void main(String[] args) throws BookException {
		BookDao booksdao=new BookDaoImpl();
		Book bk=new Book();
		Scanner sc=new Scanner(System.in);
		int i=0;
		do {
			   String Welcome="*  Enter Your Choice *";
					System.out.println(Welcome);
					System.out.println("1.Create New Book");
					System.out.println("2. Get Book Details");
					System.out.println("3. Double Price of Books");
					System.out.println("4. Delete Book ");
					System.out.println("5. Update Book Price");
					System.out.println("0. Exit ");
					i=sc.nextInt();
					switch(i) {
					case 1:
							sc.nextLine();
							System.out.println("Enter Book Name");
							String BookName=sc.nextLine();
							System.out.println("Enter Author Name");
							String author=sc.nextLine();
							System.out.println("Enter Publication Name ");
							String publication=sc.nextLine();
							System.out.println("Enter Category ");
							String category=sc.nextLine();
							System.out.println("Enter number Of Pages ");
							int pages=sc.nextInt();
							System.out.println("Enter price ");
							int price=sc.nextInt();
							booksdao.createBook(new Book(BookName, author, publication, category, pages, price,new Timestamp(System.currentTimeMillis())));


							break;
					case 2:
							 System.out.println("Enter Book Id ");
							 int bookId=sc.nextInt();
							 System.out.println(booksdao.getBookInfo(bookId));
							 break;
					case 3:
						 System.out.println("Enter Book Id ");
						 bookId=sc.nextInt();
						 System.out.println(booksdao.doubleBookPriceById(bookId));
						 break;

					case 4:

						System.out.println("Enter Book Id ");
						 bookId=sc.nextInt();
						 if(booksdao.deleteBookById(bookId)) {
							 System.out.println("Sucessfully Deleted ");

						 }
						 else {
							 System.out.println("Book Not found");
						 }
						break;	 
						
					case 5:						
						System.out.println("Enter Book by Id ");
						 bookId=sc.nextInt();
						 
						 System.out.println("Enter Book new Price");
						 price=sc.nextInt();
						 
						 BookDao bookDao = new BookDaoImpl();
						String msg = bookDao.updateBookPriceById(bookId, price);
						System.out.println("\n" + msg + "\n");
						

					}
	}while(i!=0);
		System.out.println("Bye Bye");

	}
}
