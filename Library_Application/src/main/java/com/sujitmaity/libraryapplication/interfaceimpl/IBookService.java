package com.sujitmaity.libraryapplication.interfaceimpl;

import java.util.List;

import com.sujitmaity.libraryapplication.entity.Book;



public interface IBookService {
	
	Book getBook(Integer bookId);
	
	String createBook(Book book);
	
	String updateBook(Book book);
	
	String updateAuthorName(Book book);
	
	String deleteBookId(Integer bookId);
	
	String deleteBook(String title, String authorName);
	
	List<Book> getTitleAndAuthor(String title, String authorName);

}
