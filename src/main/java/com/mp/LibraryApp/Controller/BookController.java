package com.mp.LibraryApp.Controller;

import java.util.List;
import java.util.Optional;

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

import com.mp.LibraryApp.Entity.Book;

import com.mp.LibraryApp.service.IBookService;

@RestController
@RequestMapping("/App")
public class BookController {
	
	@Autowired
	IBookService ibookservice;
	
	Logger LOGGER=LoggerFactory.getLogger(BookController.class);
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable(value="id") Integer bookId) {
		LOGGER.info("getting bookdetials for bookid: {}",bookId);
		Book book = ibookservice.getBook(bookId);
		return new ResponseEntity<Book>(book,HttpStatus.ACCEPTED);
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveBook(@RequestBody Book bk) {
		String saveBook = ibookservice.saveBook(bk);
		
		return new ResponseEntity<String>(saveBook,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/updating")
	public ResponseEntity<Book> bookUpdate(@RequestBody Book bk) {
		
		Book bookUpdate = ibookservice.bookUpdate(bk);
		return new ResponseEntity<>(bookUpdate,HttpStatus.OK);
		
	}
	
	@PatchMapping("/patch")
	public ResponseEntity<Book> bookUpdatebyId(@RequestBody Book bk) {
		Book bookUpdatebyId = ibookservice.bookUpdatebyId(bk);
		return new ResponseEntity<Book>(bookUpdatebyId,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeBook(@PathVariable(value="id") Integer bookId) {
		LOGGER.info("Deleting bookdetials for bookid: {}",bookId);
		ibookservice.removeBook(bookId);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/delete/{title}/{authorName}")
	@Transactional
	public ResponseEntity<String> removeBook(@PathVariable(value="title") String title,@PathVariable(value="authorName") String authorName) {
		LOGGER.info("deleting bookdetials title: {}  title: {}",authorName,title);
          ibookservice.removesBook(title, authorName);
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{title}/{authorName}")
	public ResponseEntity<List<Book>> getBook(@PathVariable(value="title") String title,@PathVariable(value="authorName") String authorName) {
		
		List<Book> bookTitleAndAuthor = ibookservice.getBook(title, authorName);
		return new ResponseEntity<>(bookTitleAndAuthor,HttpStatus.ACCEPTED);
		
		
	}
	
	

}
