package com.mp.library.controller;

import java.util.List;

import javax.transaction.Transactional;

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

import com.mp.library.entity.Book;
import com.mp.library.services.IBookServices;

@RestController
@RequestMapping("/library")
public class BookController {

	@Autowired
	private IBookServices bookService;
	
	
	@PostMapping("/booka")
	public ResponseEntity<String> saveBookDetails(@RequestBody Book book) {
		Book b = bookService.saveBookDetails(book);
		return new ResponseEntity<String>(b.getTitle()+" saved successfully", HttpStatus.CREATED);
	}
	
	@PutMapping("/bookc")
	public ResponseEntity<String> updateBookDetails(@RequestBody Book book) {
		Book b = bookService.updateBookDetails(book);
		return new ResponseEntity<String>(b.getTitle()+" updated successfully",HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/authornamec")
	public ResponseEntity<String> updateBookAuthor(@RequestBody Book book) {
		Book b = bookService.updateBookAuthor(book);
		return new ResponseEntity<String>("Author Name updated for: "+b.getBookId(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/book/{bookId}")
	public ResponseEntity<Book> getBookDetails(@PathVariable("bookId") Integer bookId) {
		Book b = bookService.getBookDetails(bookId);
		return new ResponseEntity<Book>(b,HttpStatus.OK);
	}
	
	@DeleteMapping("/bookr/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable("bookId") Integer bookId) {
		bookService.deleteBook(bookId);
		return new ResponseEntity<String>("Book Deleted Successfully",HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/book/{title}/{author}")
	public ResponseEntity<List<Book>> findBook(@PathVariable("title") String title, @PathVariable("author") String authorName) {
		List<Book> b = bookService.findBook(title, authorName);
		return new ResponseEntity<List<Book>>(b,HttpStatus.OK);
	}
	
	@DeleteMapping("/bookr/{title}/{author}")
	@Transactional
	public ResponseEntity<String> deleteByTitleOrAuthor(@PathVariable("title") String title, @PathVariable("author") String authorName) {
		bookService.deleteByTitleOrAuthor(title, authorName);
		return new ResponseEntity<String>("Book Deleted Successfully",HttpStatus.NO_CONTENT);
	}
}
