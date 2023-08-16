package com.Problem2;

import javax.persistence.EntityManager;

public class BookDaoImpl implements BookDao {

	EntityManager em;
	Book book;
	public void createBook(Book book) {
		em=EMutil2.getConnection();
		em.getTransaction().begin();
		em.persist(book);
		System.out.println("new Book Added Sucessfully");
		em.getTransaction().commit();
		em.close();
		
	}

	public Book getBookInfo(int bookId) {
		em=EMutil2.getConnection();
		book=new Book();
		book=em.find(Book.class, bookId);

		return book;
	}

	public boolean deleteBookById(int bookId) {
		em=EMutil2.getConnection();
		book=new Book();
		book=em.find(Book.class, bookId);
		if(book!=null) {
			em.remove(book);
			return true;
		}
		return false;
	}

	public String doubleBookPriceById(int bookId) {
		em=EMutil2.getConnection();
		book=new Book();
		book=em.find(Book.class, bookId);
		if(book!=null) {
			book.setPrice(book.getPrice()+book.getPrice());
			return "Price updated Suscessfully";
		}
		return "Book Not found";
	}

	 public String updateBookPriceById(int id, int price) {
	        String msg = "Unable to update book";
	        EntityManager em = EMutil2.getConnection();

	        Book book = em.find(Book.class, id);
	        if(book != null){
	            em.getTransaction().begin();
	            book.setPrice(price);
	            em.getTransaction().commit();
	            msg = "Book updated";
	        }
	       
	        return msg;
	    }
}
