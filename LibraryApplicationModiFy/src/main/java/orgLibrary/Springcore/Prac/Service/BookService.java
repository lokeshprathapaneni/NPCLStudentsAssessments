package orgLibrary.Springcore.Prac.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import orgLibrary.Springcore.Prac.Book.Book;
import orgLibrary.Springcore.Prac.Dao.BookDao;
import orgLibrary.Springcore.Prac.LengthTitleException.BookIdIsNotPresentException;
import orgLibrary.Springcore.Prac.LengthTitleException.BookIdIsNotValid;
import orgLibrary.Springcore.Prac.LengthTitleException.LengthTitleException;
import orgLibrary.Springcore.Prac.LengthTitleException.yearOfPublishException;

@Service

public class BookService {
	@Autowired
	BookDao bookdao;
	
	Logger LOGGER=LoggerFactory.getLogger("BookService.class");
	public Book getBook(Integer bookId) {
		LOGGER.info("retrieving book{}",bookId);
		Optional<Book> bookReco = bookdao.findById(bookId);
		if(!bookReco.isPresent()) {
			throw new BookIdIsNotValid("invalid book id ");
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
	public String createLib(Book bo) {
		bookdao.save(bo);
		return "save successfully";
	}
	public String updateBook(Book book) {
		bookdao.save(book);
		return "put successfully";
		
	}
	public String updateAuthorAddress(Book book) {
		if(book.getBookId()==null) {
			throw new BookIdIsNotPresentException("invalid book id is present");
		}
		Optional<Book> boop = bookdao.findById(book.getBookId());
		
		
		Book ad=boop.get();
		ad.setAuthorName(book.getAuthorName());
		bookdao.save(ad);
		return "successful save";
	}
	public String deleteBookId(Integer bookId) {
		bookdao.deleteByBookId(bookId);
		return "delete bookid";
	}
	public List<Book>getTitleAndAuthor(String title,String authorName){
		List<Book> a = bookdao.findByTitleAndAuthorName(title, authorName);	
		return a;
	}
	public String deleteBookId(String title,String authorName) {
		bookdao.deleteByTitleOrAuthorName(title, authorName);
		return "deleted title name or aauthor name";
	}

}
