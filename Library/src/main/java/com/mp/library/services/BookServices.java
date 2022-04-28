package com.mp.library.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mp.library.dao.BookDao;
import com.mp.library.entity.Book;
import com.mp.library.exception.NullBookIdException;
import com.mp.library.exception.StringOutOfBoundException;
import com.mp.library.exception.YearOutOfBoundException;

@Service
public class BookServices implements IBookServices{

	@Autowired
	private BookDao bookDao;
	
	Logger LOGGER = LoggerFactory.getLogger("BookServices.class");
	
	@Override
	public Book saveBookDetails(Book book) {
		LOGGER.info("Saving Book details for Book Id: {}.",book.getBookId());
		if(book.getTitle().length() > 30) {
			throw new StringOutOfBoundException("Title length is "+book.getTitle().length()+" instead of 30");
		}
		else if(book.getYearOfPublish() > 2022) {
			throw new YearOutOfBoundException("Year of publish should be less that or equal to current year: 2022");
		}
		Book b = bookDao.save(book);
		LOGGER.info("Book details for Book Id: {} saved.",book.getBookId());
		return b;
	}
	
	@Override
	public Book updateBookDetails(Book book) {
		LOGGER.info("Updating Book details for Book Id: {}.",book.getBookId());
		bookDao.save(book);
		LOGGER.info("Book details for Book Id: {} updated.",book.getBookId());
		return book;
	}
	
	@Override
	public Book updateBookAuthor(Book book) {
		LOGGER.info("Updating Author Name for Book Id: {}.",book.getBookId());
		if(book.getBookId() == null) {
			throw new NullBookIdException("Book Id is Mandatory");
		}
		Optional<Book> bookOpt = bookDao.findById(book.getBookId());
		Book b = bookOpt.get();
		b.setAuthorName(book.getAuthorName());
		bookDao.save(b);
		LOGGER.info("Author Name for Book Id: {} updated.",book.getBookId());
		return book;
	}
	
	@Override
	public Book getBookDetails(Integer bookId) {
		LOGGER.info("Getting Details for Book Id: {}.",bookId);
		Optional<Book> bookRecord = bookDao.findById(bookId);
		if(bookRecord.isEmpty()) {
			throw new NullBookIdException("Book Id: "+bookId+" does not exist");
		}
		LOGGER.info("Got Details for Book Id: {}.",bookId);
		return bookRecord.get();
	}
	
	@Override
	public String deleteBook(Integer bookId) {
		LOGGER.info("Deleting Details of Book for Book Id: {}.",bookId);
		bookDao.deleteById(bookId);
		LOGGER.info("Book Details Deleted for Book Id: {}.",bookId);
		return "Book Deleted Successfully";
	}
	
	@Override
	public List<Book> findBook(String title, String authorName) {
		LOGGER.info("Finding Details for All Book with Title: '{}' and Author: '{}'.",title,authorName);
		List<Book> bookRecord = bookDao.findByTitleAndAuthorName(title ,authorName);
		LOGGER.info("All Book with Title: '{}' and Author: '{}' found.",title,authorName);
		return bookRecord;
	}
	
	@Override
	public String deleteByTitleOrAuthor(String title,String authorName) {
		LOGGER.info("Deleting Details for All Book with Title: '{}' or Author: '{}'.",title,authorName);
		bookDao.deleteByTitleOrAuthorName(title, authorName);
		LOGGER.info("All Book with Title: '{}' or Author: '{}' deleted.",title,authorName);
		return "Book Deleted Successfully";
	}
}
