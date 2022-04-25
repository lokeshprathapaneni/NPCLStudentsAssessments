package com.mp.Library.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mp.Library.dao.BookDao;
import com.mp.Library.services.*;
import com.mp.Library.entity.Book;
import com.mp.Library.exception.CheckTitleException;
import com.mp.Library.exception.StringOutOfBoundException;
import com.mp.Library.exception.YearOutOfBoundException;
import java.util.List;
import java.util.Optional;



@Service
public class BookServices implements IBookservices {
	
	
		@Autowired
		private BookDao bookDao;
		
		Logger LOGGER = LoggerFactory.getLogger("BookServices.class");
		
		public Book saveBookDetails(Book book) {
			LOGGER.info("Saving The details for Book Id: {}.",book.getBookId());
			if(book.getTitle().length() > 30) {
				throw new StringOutOfBoundException("Book title should be less than 30 chars");
			}
			else if(book.getYearOfPublish() > 2022) {
				throw new YearOutOfBoundException("Year of publish should be less that or equal to current year: 2022");
			}
			 Book b = bookDao.save(book);
			LOGGER.info("Book details for Book Id: {} saved.",book.getBookId());
			return b;
        }
		
		public Book updateBookDetails(Book book) {
			LOGGER.info("Updating The details for Book Id: {}.",book.getBookId());
			Book updateddetails= bookDao.save(book);
			LOGGER.info("Book details for Book Id: {} updated.",book.getBookId());
			return updateddetails;
        }
	
		public Book updateAuthorName(Book book) {
			LOGGER.info("Updating The Author for Book Id: {}.",book.getBookId());
			if(book.getBookId() == null) {
				throw new CheckTitleException("Book Id is Mandatory");
			}
			Optional<Book> bookOpt = bookDao.findById(book.getBookId());
			Book b = bookOpt.get();
			b.setAuthorName(book.getAuthorName());
			bookDao.save(b);
			LOGGER.info("Author Name for Book Id: {} updated.",book.getAuthorName());
			return book;
		}
		
		public Book getBookDetails(Integer bookId) {
			LOGGER.info("Fetching Details for Book Id: {}.",bookId);
			Optional<Book> bookRecord = bookDao.findById(bookId);
			if(bookRecord.isEmpty()) {
				throw new CheckTitleException("No Title found");
			}
			LOGGER.info(" Details found for Book Id: {}.",bookId);
			return bookRecord.get();
	
	}
		public String deleteBook(Integer bookId) {
			LOGGER.info("Deleting Details for Book Id: {}.",bookId);
			bookDao.deleteById(bookId);
			return "Book Deleted Successfully";
	}
		public List<Book> getbookbytitleandauthor(String title, String authorName) {
			
			List<Book> findbytitleandauthorname = bookDao.findbytitleandauthorname(title, authorName);
			LOGGER.info("details of  bookByAuthornameAndTitle {}",findbytitleandauthorname);
			return findbytitleandauthorname;
		}
		public String deletebytitleorauthorname(String title, String authorName) {
			LOGGER.info("Deleting Books for title: '{}' or Author '{}'",title,authorName);
			bookDao.deletebytitleorauthorname(title,authorName);
			LOGGER.info("Title: {} or Author : {} deleted successfully",title,authorName);
			return "book deleted successfully";
	    }

		
}
		

