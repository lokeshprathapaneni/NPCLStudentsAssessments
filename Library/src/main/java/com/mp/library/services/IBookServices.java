package com.mp.library.services;

import java.util.List;

import com.mp.library.entity.Book;

public interface IBookServices {

	Book saveBookDetails(Book book);
	
	Book updateBookDetails(Book book);
	
	Book updateBookAuthor(Book book);
	
	Book getBookDetails(Integer bookId);
	
	String deleteBook(Integer bookId);
	
	List<Book> findBook(String title, String authorName);
	
	String deleteByTitleOrAuthor(String title,String authorName);
}
