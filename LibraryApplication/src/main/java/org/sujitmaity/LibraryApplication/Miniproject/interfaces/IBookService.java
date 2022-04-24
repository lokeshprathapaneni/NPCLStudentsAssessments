package org.sujitmaity.LibraryApplication.Miniproject.interfaces;

import java.util.List;

import org.sujitmaity.LibraryApplication.Miniproject.BookClacc.BookClass;

public interface IBookService {
	
	BookClass getBook(Integer bookId);
	
	String createBook(BookClass book);
	
	String updateBook(BookClass book);
	
	String updateAuthorName(BookClass book);
	
	String deleteBookId(Integer bookId);
	
	String deleteBook(String title, String authorName);
	
	List<BookClass> getTitleAndAuthor(String title, String authorName);

}
