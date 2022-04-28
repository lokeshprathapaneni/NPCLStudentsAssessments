package com.mp.libraryapp.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mp.libraryapp.dao.BookDao;
import com.mp.libraryapp.entity.Book;
import com.mp.libraryapp.exceptions.BookIDInvalidException;
import com.mp.libraryapp.exceptions.BookIdNotProvidedException;
import com.mp.libraryapp.exceptions.TitleLengthNotAllowedException;
import com.mp.libraryapp.exceptions.YearInvalidException;

@Service
public class BookServices implements IBookServices {

	@Autowired
	private BookDao bookDao;

	Logger LOGGER = LoggerFactory.getLogger("BookServices.class");


	@Override
	public Book createBook(Book book)
	{
		LOGGER.info("Creating a Book for Book Id: {}.",book.getBookId());
		if(((book.getTitle()).length())>30) {
			throw new TitleLengthNotAllowedException("Book Title Should be less than 30");
		}
		if(book.getYearOfPublish()>2022) {
			throw new YearInvalidException("Year of Publish should be less than or equal to current year");
		}
		Book b = bookDao.save(book);
		LOGGER.info("Book details for Book Id: {} saved.",book.getBookId());
		return b;
	}

	@Override
	public Book updateBook(Book book) {
		LOGGER.info("Updating Book for Book Id: {}.",book.getBookId());
		bookDao.save(book);
		LOGGER.info("Book Id: {} updated.",book.getBookId());
		return book;
	}

	@Override
	public Book updateAuthorName(Book book) {
		if(book.getBookId()== null) {
			throw new BookIdNotProvidedException("Book Id is Mandatory");
		}
		LOGGER.info("Updating Author name for Book Id: {}.",book.getBookId());
		Optional<Book> bookOpt = bookDao.findById(book.getBookId());
		Book b = bookOpt.get();
		b.setAuthorName(book.getAuthorName());
		bookDao.save(b);
		LOGGER.info("Author Name for Book Id: {} updated successfully.",book.getBookId());
		return book;
	}

	@Override
	public Book getBook(Integer bookId) {
		LOGGER.info("Retrieving book :- {}",bookId); 
		Optional<Book> bookRecord = bookDao.findById(bookId); 
		//LOGGER.info("retrived book :-{}", bookRecord);
		if(bookRecord.isEmpty()) {
			LOGGER.info("Book id not found {}",bookId);
			throw new BookIDInvalidException("Book id: " + bookId + " does not exist");
		}
		return bookRecord.get(); 
	}

	@Override
	public String deleteBook(Integer bookId) {
		LOGGER.info("Deleting Book for Book Id: {}.",bookId);
		bookDao.deleteById(bookId);
		LOGGER.info("Book Id: {} deleted successfully.",bookId);
		return "book deleted successfully";

	}

	@Override
	public Book getBookByTitleAndAuthor(String title,String authorName) {
		LOGGER.info("Retrieving book{}",title,authorName); 
		Optional<Book> bookRecord = bookDao.findByTitleAndAuthorName(title,authorName); 
		LOGGER.info("retrived book{}", bookRecord);
		return bookRecord.get();
	}

	@Override
	public String deleteByTitleOrAuthorName(String title,String authorName) {
		LOGGER.info("Deleting Books for title: '{}' or Author '{}'.",title,authorName);
		bookDao.deleteByTitleOrAuthorName(title,authorName);
		LOGGER.info("Title: {} or Author : {} deleted successfully.",title,authorName);
		return "book deleted successfully";
	}

}

