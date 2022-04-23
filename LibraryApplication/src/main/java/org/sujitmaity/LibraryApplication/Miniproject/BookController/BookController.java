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
import org.sujitmaity.LibraryApplication.Miniproject.Services.BookClassServices;

@RestController
@RequestMapping("/bookclass")
public class BookController {
	
	@Autowired
	BookDAO bookDao;
	
	Logger LOGGER = LoggerFactory.getLogger("BookController.class");
	
	@GetMapping("/get/{bookId}")
	public ResponseEntity<BookClass> getBook(@PathVariable("bookId") Integer bookId) {
		LOGGER.info("retrieving bookClass {}", bookId);
		
		Optional<BookClass> booRecord=bookDao.findById(bookId);
		
		 if(!booRecord.isPresent()){
				BookClass bc1=new BookClassServices().createBook(booRecord);
			}
		 
		BookClass bk=booRecord.get();
		
		if(bk.getTitle().length()>30) {
			BookClass bc2= new BookClassServices().createBook1(bk);
		}
		
		 if(bk.getYearOfPublish()>2022){
			BookClass bc3= new BookClassServices().createBook2(bk);
		}
		 
		 LOGGER.info("retrieving bookClass {}", booRecord.get());
		 HttpHeaders httpHeaders = new HttpHeaders();
		 httpHeaders.add("UserName", "Sujit Shibaprasad Maity");
		 httpHeaders.add("Transfer-Encoding", "BackendService");
		 
		return new ResponseEntity<BookClass>(booRecord.get(),httpHeaders,HttpStatus.OK) ;
	}
	
	@PostMapping("/post")
	public ResponseEntity<String> createBook(@RequestBody BookClass book) {
		bookDao.save(book);
		return new ResponseEntity<String>("Save Successfully",HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/put")
	public ResponseEntity<String> updateBook(@RequestBody BookClass book) {
		bookDao.save(book);
		return new ResponseEntity<String>("Save Successfully to DataBase Server",HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/put/authorName")
	public ResponseEntity<BookClass> updateBookClass(@RequestBody BookClass book) {
		if(book.getBookId()==null) {
			BookClass bc4= new BookClassServices().createBook3(book);
		}
		Optional<BookClass> bookput = bookDao.findById(book.getBookId());
		BookClass bk = bookput.get();
		bk.setAuthorName(book.getAuthorName());
		bookDao.save(bk);
		return new ResponseEntity<BookClass>(HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{bookId}")
	@Transactional
	public ResponseEntity<String> deleteBookId(@PathVariable("bookId") Integer bookId) {
		bookDao.deleteById(bookId);
		return new ResponseEntity<String>("Successfully Delete Book",HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{title}{authorName}")
	@Transactional
	public ResponseEntity<String> deleteBookId1(@PathVariable("title") String title, @PathVariable("authorName") String authorName) {
		bookDao.deleteByTitleOrAuthorName(title, authorName);
		return new ResponseEntity<String>("Successfully Delete Book Title And Author",HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/get/{title}{authorName}")
	public ResponseEntity<List<BookClass>> getTitleAndAuthorName(@PathVariable("title") String title, @PathVariable("authorName") String authorName){
		List<BookClass> boo=bookDao.findByTitleAndAuthorName(title, authorName);
		return new ResponseEntity<List<BookClass>>(boo,HttpStatus.OK);
	}
}
