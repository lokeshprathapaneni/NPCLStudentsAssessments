package com.npci.spring_mini_project.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.spring_mini_project.dao.BookRepository;
import com.npci.spring_mini_project.entity.Book;
import com.npci.spring_mini_project.exception.BookIdCheckException;
import com.npci.spring_mini_project.exception.PublishYearException;
import com.npci.spring_mini_project.exception.TitleCheckException;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookRepository bookRepo;
	
	Logger LOGGER = LoggerFactory.getLogger("BookController.class");

	@PostMapping(value = "/adddetails")
	public String saveBookDetails(@RequestBody Book book) {
		LOGGER.info("Saving Book details for bookId:{}",book.getBookId());
		if (book.getTitle().length() > 30) {
			throw new TitleCheckException("Book Tiltle Length should be less than 30 characters");
		}

		if (book.getYearOfPublish() >= 2022) {
			throw new PublishYearException("Year of publish should be less than or Equals to current year");
		}
		
		bookRepo.save(book);
		LOGGER.info("Book details for bookId:{} has been saved",book.getBookId());
		return "Book Details has been saved for Book id " + book.getBookId();
	}

	@PutMapping("/detailsUpdate")
	public Book updateBookDetails(@RequestBody Book book) {
		LOGGER.info("Updating book details for bookId:{}",book.getBookId());
		Book updatedDetails = bookRepo.save(book);
		LOGGER.info("Book details for bookId:{} has been updated",book.getBookId());
		return updatedDetails;
	}

	@PatchMapping("/authorNameUp")
	public Book updateAuthorName(@RequestBody Book book) {
		if (book.getBookId() == null) {
			throw new BookIdCheckException("Please Enter Book Id,book Id is a mandatory field.");
		}
		LOGGER.info("Updating book details for bookId:{}",book.getBookId());
		Optional<Book> findById = bookRepo.findById(book.getBookId());
		Book bookDetails = findById.get();
		bookDetails.setAuthorName(book.getAuthorName());
		bookRepo.save(bookDetails);
		LOGGER.info("Book details for bookId:{} has been updated with AuthorName:{}",book.getBookId(),book.getAuthorName());
		return bookDetails;
	}

	@GetMapping(value = "/bookById/{bookId}")
	public Book fetchBookforId(@PathVariable Integer bookId) {
		LOGGER.info("Retrieving book details for bookId:{}",bookId);
		Optional<Book> findById = bookRepo.findById(bookId);
		if (!findById.isPresent()) {
			throw new BookIdCheckException("Book Id is invalid,It doesn't exist in db");
		}
		Book book = findById.get();
		LOGGER.info("Retrieved Book details for bookId:{}  is {}",book.getBookId(),book);
		return book;

	}

	@DeleteMapping(value = "/bookRemove/{bookId}")
	public String deleteBookByid(@PathVariable Integer bookId) {
		LOGGER.info("Deleting Book details for bookId:{}",bookId);
		bookRepo.deleteById(bookId);
		LOGGER.info("Book details for bookId:{} has been deleted",bookId);
		return "Deleted Details for BookID:" + bookId;
	}

	@GetMapping(value = "/bookByTitleAndAuthor")
	public List<Book> getBookByTitleAndAuthor(@RequestBody Book book) {
		LOGGER.info("Retrieving Book details for title:{} and author:{}",book.getTitle(),book.getAuthorName());
		List<Book> findByTitleAndAuthorName = bookRepo.findByTitleAndAuthorName(book.getTitle(), book.getAuthorName());
		LOGGER.info("Retrieved Book details for title:{} and author:{} is {}",book.getTitle(),book.getAuthorName(),findByTitleAndAuthorName);
		return findByTitleAndAuthorName;

	}
	
	@DeleteMapping(value = "/removetitleorAuthor")
	@Transactional
	public String delByTitleOrAuthorName(@RequestBody Book book) {
		LOGGER.info("Deleting Book details by title:{} or author:{}",book.getTitle(),book.getAuthorName());
		bookRepo.deleteByTitleOrAuthorName(book.getTitle(),book.getAuthorName());
		LOGGER.info("Book details for title:{} or author:{} has been deleted",book.getTitle(),book.getAuthorName());
		return "Deleted the details for all Books Including Title:"+book.getTitle()+" or authorName:"+book.getAuthorName();
	}

}
