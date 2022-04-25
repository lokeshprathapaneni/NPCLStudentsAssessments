package com.mp.Library.controller;


import com.mp.Library.entity.Book;
import com.mp.Library.services.*;

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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import javax.transaction.Transactional;

public class BooksController {


@RestController
@RequestMapping(value="/library")
public class BookController {

	@Autowired
	 private BookServices bookservice;
	@PostMapping("value=/addBook")
	public ResponseEntity<String> saveBookDetails(@RequestBody Book book) {
		Book b = bookservice.saveBookDetails(book);
		return new ResponseEntity<String>(b.getTitle()+" saved successfully", HttpStatus.CREATED);
	}
	
	@PutMapping("value=/modifyBookdetails")
	public ResponseEntity<String> updateBookDetails(@RequestBody Book book) {
		Book b = bookservice.updateBookDetails(book);
		return new ResponseEntity<String>(b.getTitle()+" updated successfully",HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/changeAuthorName")
	public ResponseEntity<String> updateBookAuthor(@RequestBody Book book) {
		Book b = bookservice.updateAuthorName(book);
		return new ResponseEntity<String>("Author Name updated for: "+b.getBookId(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/book/{bookId}")
	public ResponseEntity<Book> getBookDetails(@PathVariable("bookId") Integer bookId) {
		Book b = bookservice.getBookDetails(bookId);
		return new ResponseEntity<Book>(b,HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable("bookId") Integer bookId) {
		bookservice.deleteBook(bookId);
		return new ResponseEntity<String>("Book Deleted Successfully",HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/bookBytitleandauthor")
	public ResponseEntity<List<Book>> getBookbytitleandauthor(@PathVariable("title") String title, @PathVariable("authorName") String authorName) {
		List<Book> b = bookservice.getbookbytitleandauthor(title, authorName);
		return new ResponseEntity<List<Book>>(b,HttpStatus.OK);
	}
	
	@DeleteMapping("/removebookBytitleandauthor")
	@Transactional
	public ResponseEntity<String> deletebytitleorauthorname(@PathVariable("title") String title, @PathVariable("authorName") String authorName) {
		bookservice.deletebytitleorauthorname(title,authorName);
		return new ResponseEntity<String>("Book Deleted Successfully",HttpStatus.NO_CONTENT);
	
     }
   }
}
