package com.npci.spring_mini_project.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.npci.spring_mini_project.entity.Book;

import com.npci.spring_mini_project.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bookService;

	Logger LOGGER = LoggerFactory.getLogger("BookController.class");

	@PostMapping(value = "/adddetails")
	public ResponseEntity<String> saveBookDetails(@RequestBody Book book) {
		String saveBookDetails = bookService.saveBookDetails(book);
		return new ResponseEntity<>(saveBookDetails, HttpStatus.CREATED);

	}

	@PutMapping("/detailsUpdate")
	public ResponseEntity<Book> updateBookDetails(@RequestBody Book book) {
		Book updateBookDetails = bookService.updateBookDetails(book);
		return new ResponseEntity<>(updateBookDetails, HttpStatus.OK);
	}

	@PatchMapping("/authorNameUp")
	public ResponseEntity<Book> updateAuthorName(@RequestBody Book book) {
		Book updateAuthorName = bookService.updateAuthorName(book);
		return new ResponseEntity<>(updateAuthorName, HttpStatus.OK);
	}

	@GetMapping(value = "/bookById/{bookId}")
	public ResponseEntity<Book> fetchBookforId(@PathVariable Integer bookId) {
		Book fetchBookforId = bookService.fetchBookforId(bookId);
		return new ResponseEntity<>(fetchBookforId, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/bookRemove/{bookId}")
	public ResponseEntity deleteBookByid(@PathVariable Integer bookId) {
		bookService.deleteBookByid(bookId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/bookByTitleAndAuthor")
	public ResponseEntity<List<Book>> getBookByTitleAndAuthor(@RequestBody Book book) {
		List<Book> bookByTitleAndAuthor = bookService.getBookByTitleAndAuthor(book);
		return new ResponseEntity<>(bookByTitleAndAuthor, HttpStatus.ACCEPTED);
	}

	@DeleteMapping(value = "/removetitleorAuthor")
	@Transactional
	public ResponseEntity delByTitleOrAuthorName(@RequestBody Book book) {
		bookService.delByTitleOrAuthorName(book);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
