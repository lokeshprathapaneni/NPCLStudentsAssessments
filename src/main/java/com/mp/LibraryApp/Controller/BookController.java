package com.mp.LibraryApp.Controller;

import java.util.List;
import java.util.Optional;

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

import com.mp.LibraryApp.Entity.Book;
import com.mp.LibraryApp.dao.BookDao;
import com.mp.LibraryApp.exception.BookIDException;
import com.mp.LibraryApp.exception.TitleLengthExceedException;
import com.mp.LibraryApp.exception.YearOfPublishExceedsException;

@RestController
@RequestMapping("/App")
public class BookController {
	@Autowired
	BookDao book;
	
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable(value="id") Integer bookId) {
		if(bookId ==null) {
			throw new BookIDException("Id is not found");
		}
		Optional<Book> bookdetials = book.findById(bookId);
		return bookdetials.get();
	}
	
	@PostMapping("/save")
	public String saveBook(@RequestBody Book bk) {
		if(bk.getTitle().length()>30) {
			throw new TitleLengthExceedException("title length exceeds");
		}
		else if(bk.getYearOFPublish() > 2022) {
			throw new YearOfPublishExceedsException("year should be less or equal to 2022");
			
		}
		Book b = book.save(bk);
		return "book saved successfully";
	}
	
	@PutMapping("/updating")
	public String bookUpdate(@RequestBody Book bk) {
		
		book.save(bk);
		return "Book updted successfully";
		
	}
	
	@PatchMapping("/patch")
	public String bookUpdatebyId(@RequestBody Book bk) {
		if(bk.getBookId()==null) {
			throw new BookIDException("bookId is mandatory");
		}
		Optional<Book> bookopt = book.findById(bk.getBookId());
		Book book2 = bookopt.get();
		book2.setAuthorName(bk.getAuthorName());
		book.save(bk);
		return "patch successfull";
	}
	
	@DeleteMapping("/delete/{id}")
	public String removeBook(@PathVariable(value="id") Integer bookId) {
		book.deleteById(bookId);
		return "Book deleted";
	}
	
	@DeleteMapping("/delete/{title}/{authorName}")
	public String removeBook(@PathVariable(value="title") String title,@PathVariable(value="authorName") String authorName) {
		book.deleteBytitleOrAuthorName(title, authorName);
		return "Book deleted";
	}
	
	@GetMapping("/{title}/{authorName}")
	public List<Book> getBook(@PathVariable(value="title") String title,@PathVariable(value="authorName") String authorName) {
		
		List<Book> findBytitleAndauthorName = book.findBytitleAndAuthorName(title, authorName);
		return findBytitleAndauthorName;
		
		
	}
	
	

}
