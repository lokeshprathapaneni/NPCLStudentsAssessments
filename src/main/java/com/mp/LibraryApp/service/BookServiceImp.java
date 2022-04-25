package com.mp.LibraryApp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import com.mp.LibraryApp.Entity.Book;
import com.mp.LibraryApp.dao.BookDao;
import com.mp.LibraryApp.exception.BookIDException;
import com.mp.LibraryApp.exception.TitleLengthExceedException;
import com.mp.LibraryApp.exception.YearOfPublishExceedsException;

@Service
public class BookServiceImp implements IBookService {

	@Autowired
	 BookDao book;
	 
	 Logger LOGGER=LoggerFactory.getLogger(BookServiceImp.class);
	
public Book getBook( Integer bookId) {
	 LOGGER.info("getting bookdetials for bookid: {}",bookId);
		Optional<Book> bookdetials = book.findById(bookId);
		if(!bookdetials.isPresent()) {
			throw new BookIDException("Id is not found");
		}
		
		Book Bkd = bookdetials.get();
		LOGGER.info("getting bookdetials  {}",Bkd);
		return Bkd;
	}
	
	
	
	public String saveBook( Book bk) {
		if(bk.getTitle().length()>30) {
			throw new TitleLengthExceedException("title length exceeds");
		}
		else if(bk.getYearOFPublish() > 2022) {
			throw new YearOfPublishExceedsException("year should be less or equal to 2022");
			
		}
		Book b = book.save(bk);
		LOGGER.info("Saved bookID {}",b.getBookId());
		return "book with id  " + b.getBookId() + " Saved successfuly";
	}
	
	//Updating the book details
	public Book bookUpdate(Book bk) {
		
		Book updatedetials = book.save(bk);
		LOGGER.info("Updated bookDetails {}",updatedetials);
		return updatedetials;
		
	}
	
	//updating AuthorName
	public Book bookUpdatebyId( Book bk) {
		if(bk.getBookId()==null) {
			throw new BookIDException("bookId is mandatory");
		}
		Optional<Book> bookopt = book.findById(bk.getBookId());
		Book book2 = bookopt.get();
		book2.setAuthorName(bk.getAuthorName());
		Book bookdetails = book.save(bk);
		LOGGER.info("Updated bookByAuthorname {}",bookdetails.getAuthorName());
		return bookdetails;
	}
	
	
	public String removeBook( Integer bookId) {
		book.deleteById(bookId);
		return "Deleted Book with ID "+ bookId;
	}
	
	
	public String removesBook( String title, String authorName) {
		book.deleteBytitleOrAuthorName(title, authorName);
		return "Book deleted";
	}
	
	
	public List<Book> getBook( String title, String authorName) {
		
		List<Book> findBytitleAndauthorName = book.findBytitleAndAuthorName(title, authorName);
		LOGGER.info("details of  bookByAuthornameAndTitle {}",findBytitleAndauthorName);
		return findBytitleAndauthorName;
		
		
	}
}
