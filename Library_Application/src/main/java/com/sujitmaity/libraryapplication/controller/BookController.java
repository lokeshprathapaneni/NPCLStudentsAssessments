package com.sujitmaity.libraryapplication.controller;

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
//import org.sujitmaity.LibraryApplication.Miniproject.BookClacc.BookClass;
//import org.sujitmaity.LibraryApplication.Miniproject.interfaces.IBookService;

import com.sujitmaity.libraryapplication.entity.Book;
import com.sujitmaity.libraryapplication.interfaceimpl.IBookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	IBookService booService;

	@GetMapping("/retrive/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable("bookId") Integer bookId) {
		Book bk1= booService.getBook(bookId);
		return new ResponseEntity<Book>(bk1,HttpStatus.OK) ;
	}

	@PostMapping("/add")
	public ResponseEntity<String> createBook(@RequestBody Book book) {
		String bk2=booService.createBook(book);
		return new ResponseEntity<String>(bk2,HttpStatus.ACCEPTED);
	}

	@PutMapping("/add1")
	public ResponseEntity<String> updateBook(@RequestBody Book book) {
		String bk3=booService.updateBook(book);
		return new ResponseEntity<String>(bk3,HttpStatus.ACCEPTED);
	}

	@PatchMapping("/addall/authorName")
	public ResponseEntity<String> updateAuthorName(@RequestBody Book book) {
		String bk4=booService.updateAuthorName(book);
		return new ResponseEntity<String>(bk4,HttpStatus.OK);
	}

	@DeleteMapping("/removeby/{bookId}")
	@Transactional
	public ResponseEntity<String> deleteBookId(@PathVariable("bookId") Integer bookId) {
		String bk5=booService.deleteBookId(bookId);
		return new ResponseEntity<String>(bk5,HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/removeby/{title}{authorName}")
	@Transactional
	public ResponseEntity<String> deleteBookId1(@PathVariable("title") String title, @PathVariable("authorName") String authorName) {
		String bk6= booService.deleteBook(title, authorName);
		return new ResponseEntity<String>(bk6,HttpStatus.ACCEPTED);
	}


	@GetMapping("/retriveby/{title}{authorName}")
	public ResponseEntity<List<Book>> getTitleAndAuthorName(@PathVariable("title") String title, @PathVariable("authorName") String authorName){
		List<Book> bk7= booService.getTitleAndAuthor(title, authorName);
		return new ResponseEntity<List<Book>>(bk7,HttpStatus.OK);
	}

}
