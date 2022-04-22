package com.mp.BookService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mp.BookService.dao.BookDao;
import com.mp.BookService.entity.Book;

import com.mp.BookService.exception.YearOutofBoundException;
import com.mp.BookService.exception.StringOutofBoundException;
import com.mp.BookService.exception.CheckTitleException;



public class BooksController {


@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	 BookDao bookDao;
	
	Logger LOGGER = LoggerFactory.getLogger("BookController.class");

	@PostMapping("/saveBook")
	public String saveBookDetails(@RequestBody Book book) {
		if(book.getTitle().length() > 30) {
			LOGGER.info("Book Title: {}",book.getTitle());
			throw new StringOutofBoundException("Title length is "+book.getTitle().length()+" instead of 30");
		}
		else if(book.getYearOFPublish() > 2022) {
			LOGGER.info("Year of Publish: {}",book.getYearOFPublish());
			throw new YearOutofBoundException("Year of publish should be less that or equal to current year: 2022");
		}
		Book b = bookDao.save(book);
		return b.getTitle()+" saved successfully";
	}
	

	@PutMapping("/update/book")
	public String updateBookDetails(@RequestBody Book book) {
		bookDao.save(book);
		return book.getTitle()+" updated successfully";
	}
	@PatchMapping("/authorName")
	public String updateAuthorName(@RequestBody Book book) {
		if(book.getBookid() == 0) {
			LOGGER.info("Book Id {} not inserted.",book.getBookid());
			throw new CheckTitleException("Book Id is Required");
		}
		Optional<Book> bookOpt = bookDao.findById(book.getBookid());
		Book b = bookOpt.get();   
		b.setAuthorName(book.getAuthorName());
		bookDao.save(b);
		return "Author Name updated for: "+book.getBookid();
	}

	@GetMapping(value = "/book/{bookid}")
	public Book fetchBookforId(@PathVariable("bookId") Integer bookId) {
		Optional<Book> bookRecord = bookDao.findById(bookId);
		if(bookRecord.isEmpty()) {
			LOGGER.info("Book Id {} not present.",bookId);
			throw new CheckTitleException("Book Id: "+bookId+" does not exist");
		}
		return bookRecord.get();
	}
	

	@DeleteMapping(value = "/bookRemove/{bookid}")
	public String deleteBookByid(@PathVariable("bookId") Integer bookid) {
		bookDao.deleteById(bookid);
		return "Book Deleted";
	}
	@GetMapping(value = "/bookByAuthorandTitle")
	public ListIterator<Book> findBook(@PathVariable("title") String title, @PathVariable("author") String authorName) {
		List<Book> bookRecord = bookDao.findBytitleAndauthorName(title, authorName);
		return bookRecord.listIterator();
	}
	}
	
	@DeleteMapping(value = "/removeAuthorNameOrTitle")
	@Transactional
	public String deleteByTitleOrAuthorName(@PathVariable("title") String title, @PathVariable("author") String authorName) {
		BookDao.deleteByTitleOrAuthorName(title, authorName);
		return "Book Deleted";

	}
}
