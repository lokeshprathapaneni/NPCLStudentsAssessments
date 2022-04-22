package orgLibrary.Springcore.Prac.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


import orgLibrary.Springcore.Prac.Book.Book;
import orgLibrary.Springcore.Prac.Dao.BookDao;
import orgLibrary.Springcore.Prac.LengthTitleException.BookIdIsNotPresentException;
import orgLibrary.Springcore.Prac.LengthTitleException.BookIdIsNotValid;
import orgLibrary.Springcore.Prac.LengthTitleException.LengthTitleException;
import orgLibrary.Springcore.Prac.LengthTitleException.yearOfPublishException;

@RestController
@RequestMapping("/lib")
public class BookController {
	@Autowired
	BookDao bookdao;
	
	Logger LOGGER = LoggerFactory.getLogger("BookController.class");
	@GetMapping("/id/{jumbo}")
	public Book getBook(@PathVariable("jumbo") Integer bookId) {
		LOGGER.info("retrieving book{}",bookId);
		Optional<Book> bookReco = bookdao.findById(bookId);
		 
		if(!bookReco.isPresent()) {
			throw new BookIdIsNotValid("invalid book id is present");
		}
		Book bull = bookReco.get(); 
		if(bull.getTitle().length()>30) {
			throw new LengthTitleException("book title should be less than 30 ch");
		}
		else if(bull.getYearOfPublish()>2022) {
			throw new yearOfPublishException("year of publish greater than 2022");
		}
		
		LOGGER.info("reterieving book{}",bookReco.get());
		return bookReco.get();
	}
	
	
	@PostMapping("/save")
	public String createLib(@RequestBody Book bo) {
	 bookdao.save(bo);	
		return "save successfully";
	}
	
	@PutMapping("/idupdate")
	public String updateBook(@RequestBody Book book) {
		bookdao.save(book);
		return "put successfully";
	
	}
	@PatchMapping("/admin/authorName")
	public String updateAdminAddress(@RequestBody Book book) {
		if(book.getBookId()==null) {
			throw new BookIdIsNotValid("invalid book id");
		}
		Optional<Book> boop = bookdao.findById(book.getBookId());
		
		
		Book ad=boop.get();
		ad.setAuthorName(book.getAuthorName());
		bookdao.save(ad);
		return "successful save";
		
	}
	@DeleteMapping("/bookid/{bookId}")
	@Transactional
	public String deleteBookId(@PathVariable("bookId")Integer bookId) {
		bookdao.deleteByBookId(bookId);
		return "delete bookid";
	}
	@GetMapping("/book/{title}/{authorName}")
	public List<Book>getTitleAndAuthor(@PathVariable("title")String title,@PathVariable("authorName")String authorName){
		List<Book> a = bookdao.findByTitleAndAuthorName(title, authorName);	
		return a;
}
	@DeleteMapping("/bid/{title}/{authorName}")
	@Transactional
	public String deleteBookId(@PathVariable("title")String title,@PathVariable("authorName")String authorName) {
		bookdao.deleteByTitleOrAuthorName(title, authorName);
		return "deleted title name or aauthor name";
	}
}

