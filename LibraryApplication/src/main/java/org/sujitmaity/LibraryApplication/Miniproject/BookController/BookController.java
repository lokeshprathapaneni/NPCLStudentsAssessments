package org.sujitmaity.LibraryApplication.Miniproject.BookController;

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
import org.sujitmaity.LibraryApplication.Miniproject.BookClacc.BookClass;
import org.sujitmaity.LibraryApplication.Miniproject.BookDAO.BookDAO;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.BookIdIsInvalid;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.BookIdIsNotPresentException;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.LengthOfTitleException;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.YearOfPublishException;

@RestController
@RequestMapping("/bookclass")
public class BookController {
	
	@Autowired
	BookDAO bookDao;
	
	Logger LOGGER = LoggerFactory.getLogger("BookController.class");
	
	@GetMapping("/get/{bookId}")
	public BookClass getBook(@PathVariable("bookId") Integer bookId) {
		LOGGER.info("retrieving bookClass {}", bookId);
		Optional<BookClass> booRecord=bookDao.findById(bookId);
		 if(!booRecord.isPresent()){
				throw new BookIdIsInvalid("Book Id is Not Present in Database");
			}
		 
		BookClass bk=booRecord.get();
		if(bk.getTitle().length()>30) {
			throw new LengthOfTitleException("Book Title Should Less Than 30 Characters.");
		}
		 if(bk.getYearOfPublish()>2022){
			throw new YearOfPublishException("year of publish should be less than or equals to current year.");
		}
		 LOGGER.info("retrieving bookClass {}", booRecord.get());
		return booRecord.get();
	}
	
	@PostMapping("/post")
	public String createBook(@RequestBody BookClass book) {
		bookDao.save(book);
		return "Save Successfully to DataBase Server";
	}
	
	@PutMapping("/put")
	public String updateBook(@RequestBody BookClass book) {
		bookDao.save(book);
		return "Save Successfully to DataBase Server";
	}
	
	@PatchMapping("/put/authorName")
	public String updateBookClass(@RequestBody BookClass book) {
		if(book.getBookId()==null) {
			throw new BookIdIsNotPresentException("BookId Is Mandatory");
		}
		Optional<BookClass> bookput = bookDao.findById(book.getBookId());
		BookClass bk = bookput.get();
		bk.setAuthorName(book.getAuthorName());
		bookDao.save(bk);
		return "Update In Database Server Successfully";
	}
	
	@DeleteMapping("/delete/{bookId}")
	@Transactional
	public String deleteBookId(@PathVariable("bookId") Integer bookId) {
		bookDao.deleteById(bookId);
		return "Successfully Delete Book";
	}
	
	@DeleteMapping("/delete/{title}{authorName}")
	@Transactional
	public String deleteBookId1(@PathVariable("title") String title, @PathVariable("authorName") String authorName) {
		bookDao.deleteByTitleOrAuthorName(title, authorName);
		return "Successfully Delete Book Title And Author";
	}
	
	
	@GetMapping("/get/{title}{authorName}")
	public List<BookClass> getTitleAndAuthorName(@PathVariable("title") String title, @PathVariable("authorName") String authorName){
		List<BookClass> boo=bookDao.findByTitleAndAuthorName(title, authorName);
		return boo;
	}
}
