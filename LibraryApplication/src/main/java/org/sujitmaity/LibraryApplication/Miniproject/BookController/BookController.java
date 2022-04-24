package org.sujitmaity.LibraryApplication.Miniproject.BookController;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sujitmaity.LibraryApplication.Miniproject.BookClacc.BookClass;
import org.sujitmaity.LibraryApplication.Miniproject.BookDAO.BookDAO;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.BookIdIsInvalid;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.BookIdIsNotPresentException;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.LengthOfTitleException;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.YearOfPublishException;
import org.sujitmaity.LibraryApplication.Miniproject.interfaces.IBookService;

@RestController
@RequestMapping("/bookclass")
public class BookController {	

	@Autowired
	IBookService booService;

	@GetMapping("/get/{bookId}")
	public ResponseEntity<BookClass> getBook(@PathVariable("bookId") Integer bookId) {
		BookClass bk1= booService.getBook(bookId);
		return new ResponseEntity<BookClass>(bk1,HttpStatus.OK) ;
	}

	@PostMapping("/post")
	public ResponseEntity<String> createBook(@RequestBody BookClass book) {
		String bk2=booService.createBook(book);
		return new ResponseEntity<String>(bk2,HttpStatus.ACCEPTED);
	}

	@PutMapping("/put")
	public ResponseEntity<String> updateBook(@RequestBody BookClass book) {
		String bk3=booService.updateBook(book);
		return new ResponseEntity<String>(bk3,HttpStatus.ACCEPTED);
	}

	@PatchMapping("/put/authorName")
	public ResponseEntity<String> updateAuthorName(@RequestBody BookClass book) {
		String bk4=booService.updateAuthorName(book);
		return new ResponseEntity<String>(bk4,HttpStatus.OK);
	}

	@DeleteMapping("/delete/{bookId}")
	@Transactional
	public ResponseEntity<String> deleteBookId(@PathVariable("bookId") Integer bookId) {
		String bk5=booService.deleteBookId(bookId);
		return new ResponseEntity<String>(bk5,HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{title}{authorName}")
	@Transactional
	public ResponseEntity<String> deleteBookId1(@PathVariable("title") String title, @PathVariable("authorName") String authorName) {
		String bk6= booService.deleteBook(title, authorName);
		return new ResponseEntity<String>(bk6,HttpStatus.ACCEPTED);
	}


	@GetMapping("/get/{title}{authorName}")
	public ResponseEntity<List<BookClass>> getTitleAndAuthorName(@PathVariable("title") String title, @PathVariable("authorName") String authorName){
		List<BookClass> bk7= booService.getTitleAndAuthor(title, authorName);
		return new ResponseEntity<List<BookClass>>(bk7,HttpStatus.OK);
	}
}











