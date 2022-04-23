package org.libraryapp.springcore.prac.bookcontroller;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.libraryapp.springcore.prac.bookclass.Book;
import org.libraryapp.springcore.prac.interfaces.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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




@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	IBookService bservice;
	
	@GetMapping("/id/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable("bookId") Integer bookId ) {
		Book b1=bservice.getBook(bookId);
		
		return new ResponseEntity<Book>(b1,HttpStatus.OK);
	}
	
	
	@PostMapping("save")
	public ResponseEntity<String> createBook(@RequestBody Book book) {
		String b2=bservice.createBook(book);
		return new ResponseEntity<String>(b2,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/Id")
	public ResponseEntity<String> updateBook(@RequestBody Book book) {
		String b3=bservice.updateBook(book);
		return new ResponseEntity<String>(b3,HttpStatus.CREATED);
	}
	
	@PatchMapping("/adm/authorName")
	public ResponseEntity<String> updateAuthorName(@RequestBody Book book) {
		String b4=bservice.updateAuthorName(book);
		return new ResponseEntity<String>(b4,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/bid1/{bookId}")
	@Transactional
	public ResponseEntity<String> deleteBookId(@PathVariable("bookId") Integer bookId) {
		String b5=bservice.deleteBookId(bookId);
		return new ResponseEntity<String>(b5,HttpStatus.FOUND);
	}
	
	@GetMapping("/bk/{title}/{authorName}")
	public ResponseEntity<List<Book>> getTitleAndAuthor(@PathVariable("title") String title,@PathVariable("authorName") String authorName){
		List<Book> b6=bservice.getTitleAndAuthor(title, authorName);
		return new ResponseEntity<List<Book>>(b6,HttpStatus.OK);
	}
	
	@DeleteMapping("/bid/{title}/{authorName}")
	@Transactional
	public ResponseEntity<String> deleteBookId(@PathVariable("title") String title,@PathVariable("authorName") String authorName) {
		String b7=bservice.deleteBookId(title, authorName);
		return new ResponseEntity<String>(b7,HttpStatus.FOUND);
	}
	

}

