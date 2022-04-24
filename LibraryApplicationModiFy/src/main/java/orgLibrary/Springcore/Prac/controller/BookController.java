package orgLibrary.Springcore.Prac.controller;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

import orgLibrary.Springcore.Prac.Book.Book;
import orgLibrary.Springcore.Prac.Dao.BookDao;
import orgLibrary.Springcore.Prac.LengthTitleException.BookIdIsNotPresentException;
import orgLibrary.Springcore.Prac.LengthTitleException.BookIdIsNotValid;
import orgLibrary.Springcore.Prac.LengthTitleException.LengthTitleException;
import orgLibrary.Springcore.Prac.LengthTitleException.yearOfPublishException;
import orgLibrary.Springcore.Prac.Service.BookService;

@RestController
@RequestMapping("/lib")
public class BookController {
	@Autowired
	BookService bservice;
	
	
	Logger LOGGER = LoggerFactory.getLogger("BookController.class");
	@GetMapping("/id/{jumbo}")
	public ResponseEntity<Book> getBook(@PathVariable("jumbo") Integer bookId) {
		Book b1=bservice.getBook(bookId);
//		LOGGER.info("retrieving book{}",bookId);
//		Optional<Book> bookReco = bookdao.findById(bookId);
//		if(!bookReco.isPresent()) {
//			throw new BookIdIsNotValid("invalid book id ");
//		}
//		Book bull = bookReco.get(); 
//		if(bull.getTitle().length()>30) {
//			throw new LengthTitleException("book title should be less than 30 ch");
//		}
//		else if(bull.getYearOfPublish()>2022) {
//			throw new yearOfPublishException("year of publish greater than 2022");
//		}
//		
//		LOGGER.info("reterieving book{}",bookReco.get());
//		 HttpHeaders httpHeaders=new HttpHeaders();
//		 httpHeaders.add("UserName","Ram");
//		 httpHeaders.add("Transfer Encoding", "computing");
		 
		
		return new ResponseEntity<Book>(b1,HttpStatus.OK);
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<String> createLib(@RequestBody Book bo) {
		String b2=bservice.createLib(bo);
		return new ResponseEntity<String>(b2,HttpStatus.OK);
	}
	
	@PutMapping("/idupdate")
	public ResponseEntity<String> updateBook(@RequestBody Book book) {
		String b3=bservice.updateBook(book);
		return new ResponseEntity<String>(b3,HttpStatus.OK);
	
	}
	@PatchMapping("/admin/authorName")
	public ResponseEntity<String> updateAuthorAddress(@RequestBody Book book) {
		String b4=bservice.updateAuthorAddress(book);
		return new ResponseEntity<String>(b4,HttpStatus.OK);
		
		
	}
	@DeleteMapping("/bookid/{bookId}")
	@Transactional
	public ResponseEntity<String> deleteBookId(@PathVariable("bookId")Integer bookId) {
		String b5=bservice.deleteBookId(bookId);
		return new ResponseEntity<String>(b5,HttpStatus.OK);
	}
	@GetMapping("/book/{title}/{authorName}")
	public ResponseEntity<List<Book>>getTitleAndAuthor(@PathVariable("title")String title,@PathVariable("authorName")String authorName){
		List<Book> b6 =bservice.getTitleAndAuthor(title, authorName);	
		return new ResponseEntity<List<Book>>(b6,HttpStatus.OK);
}
	@DeleteMapping("/bid/{title}/{authorName}")
	@Transactional
	public ResponseEntity<String> deleteBookId(@PathVariable("title")String title,@PathVariable("authorName")String authorName) {
		String b7=bservice.deleteBookId(title, authorName);
		return new ResponseEntity<String>(b7,HttpStatus.OK);
	}
}

