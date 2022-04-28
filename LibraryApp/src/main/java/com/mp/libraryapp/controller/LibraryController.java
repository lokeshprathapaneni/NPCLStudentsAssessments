package com.mp.libraryapp.controller;

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
import com.mp.libraryapp.entity.Book;
import com.mp.libraryapp.services.IBookServices;


@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private IBookServices bookService;


	@PostMapping("/book")
	public ResponseEntity<String> createBook(@RequestBody Book book) {
		Book b = bookService.createBook(book);
		return new ResponseEntity<String>(b.getTitle()+" saved successfully", HttpStatus.CREATED);

	}
	@PutMapping("/ubook")
	public ResponseEntity<String> updatebook(@RequestBody Book book) {
		Book b = bookService.updateBook(book);
		return new ResponseEntity<String>(b.getTitle()+" updated successfully",HttpStatus.ACCEPTED);
	}

	@PatchMapping("/book/authorname")
	public ResponseEntity<String> updateAuthorName(@RequestBody Book book) {
		Book b = bookService.updateAuthorName(book);
		return new ResponseEntity<String>("Author Name updated for BookID: "+b.getBookId() + "successfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/book/{BookId}")
	public ResponseEntity<Book> getBook(@PathVariable("BookId") Integer bookId) {
		Book b = bookService.getBook(bookId);
		return new ResponseEntity<Book>(b,HttpStatus.OK);
	}

	@DeleteMapping("/id/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId)
	{
		bookService.deleteBook(bookId);
		return new ResponseEntity<String>("Book Deleted successfully",HttpStatus.NO_CONTENT);
	}


	@GetMapping("/atbook/{title}/{author}")
	public ResponseEntity<Book> getBookByTitleAndAuthor(@PathVariable("title") String title, @PathVariable("author") String authorName)
	{
		Book b = bookService.getBookByTitleAndAuthor(title,authorName);
		return new ResponseEntity<Book>(b,HttpStatus.OK);
	}

	@DeleteMapping("/bookby/{title}/{author}")
	@Transactional
	public ResponseEntity<String> deleteByTitleOrAuthorNam(@PathVariable("title") String title, @PathVariable("author") String authorName)
	{
		bookService.deleteByTitleOrAuthorName(title,authorName);
		return new ResponseEntity<String>("Book Deleted Successfully",HttpStatus.NO_CONTENT);
	}

}
