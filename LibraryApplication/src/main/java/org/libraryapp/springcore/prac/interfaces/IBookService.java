package org.libraryapp.springcore.prac.interfaces;

import java.util.List;
import java.util.Optional;

import org.libraryapp.springcore.prac.bookclass.Book;
import org.libraryapp.springcore.prac.exception.BookIdIsNotPresentException;
import org.libraryapp.springcore.prac.exception.BookIdIsNotValid;
import org.libraryapp.springcore.prac.exception.LengthTitleException;
import org.libraryapp.springcore.prac.exception.YearOfPublishException;

public interface IBookService {
	 Book getBook(Integer bookId);
	
	 String createBook(Book book);
	
	 String updateBook(Book book);
	
	
	 String updateAuthorName(Book book);
	
	 String deleteBookId(Integer bookId);
	
	List<Book> getTitleAndAuthor(String title, String authorName);
	
	 String deleteBookId(String title, String authorName);
	
	

}
