package orgLibraryApp.Springcore.Prac.BookController;


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


import orgLibraryApp.Springcore.Prac.BookClass.Book;
import orgLibraryApp.Springcore.Prac.BookDao.BookDao;
import orgLibraryApp.Springcore.Prac.Exception.BookIdIsNotPresentException;
import orgLibraryApp.Springcore.Prac.Exception.BookIdIsNotValid;
import orgLibraryApp.Springcore.Prac.Exception.LengthTitleException;
import orgLibraryApp.Springcore.Prac.Exception.YearOfPublishException;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookDao bDao;
	
	Logger LOGGER=LoggerFactory.getLogger("BookController.class");
	@GetMapping("/id/{bookId}")
	public Book getBook(@PathVariable("bookId") Integer bookId ) {
		LOGGER.info("retrieving book{}", bookId);
		
		Optional<Book> bookRecord=bDao.findById(bookId);
		if(!bookRecord.isPresent()) {
			throw new BookIdIsNotValid(" bookID doesnt exist in db");
		}
		Book b=bookRecord.get();
		if(b.getTitle().length()>30) {
			throw new LengthTitleException("book title should be less than 30 charecters");
		}
		 if(b.getYearOfPublish()>2022) {
			throw new YearOfPublishException("year of publish should be less than or equals to current year");
		}
		
		LOGGER.info("retrieving book{}",bookRecord.get());
		return bookRecord.get();
	}
	
	
	@PostMapping("save")
	public String createBook(@RequestBody Book book) {
		bDao.save(book);
		return "save successfully by post";
	}
	
	@PutMapping("/Id")
	public String updateBook(@RequestBody Book book) {
		bDao.save(book);
		return "saved Successfully";
	}
	
	@PatchMapping("/adm/authorName")
	public String updateAdminAddress(@RequestBody Book book) {
		 if(book.getBookId()==null) {
				throw new BookIdIsNotPresentException("bookId is mandatory");
		}
		Optional<Book> bookOp=bDao.findById(book.getBookId());
		Book ad=bookOp.get();
		ad.setAuthorName(book.getAuthorName());
		bDao.save(ad);
		return "update Successfully";
		
	}
	
	@DeleteMapping("/bid1/{bookId}")
	@Transactional
	public String deleteBookId(@PathVariable("bookId") Integer bookId) {
		bDao.deleteByBookId(bookId);
		return "Deleted BookId";
	}
	
	@GetMapping("/bk/{title}/{authorName}")
	public List<Book> getTitleAndAuthor(@PathVariable("title") String title,@PathVariable("authorName") String authorName){
		List<Book> b=bDao.findByTitleAndAuthorName(title, authorName);
		return b;
	}
	
	@DeleteMapping("/bid/{title}/{authorName}")
	@Transactional
	public String deleteBookId(@PathVariable("title") String title,@PathVariable("authorName") String authorName) {
		bDao.deleteByTitleOrAuthorName(title, authorName);
		return "Deleted Title or AuthorName";
	}
	

}
