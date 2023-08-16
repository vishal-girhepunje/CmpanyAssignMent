package com.Problem2;

public interface BookDao {
	public void createBook(Book book);
	public Book getBookInfo(int bookId);
	public 	boolean deleteBookById(int bookId);
	public String doubleBookPriceById(int bookId );
	public String updateBookPriceById(int id, int price) ;
}
