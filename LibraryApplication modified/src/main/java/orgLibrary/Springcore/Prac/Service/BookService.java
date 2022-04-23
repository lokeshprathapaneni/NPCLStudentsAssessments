package orgLibrary.Springcore.Prac.Service;

import java.util.Optional;

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
	
	public Book retrieveBook(Optional<Book>bookReco) {
		throw new BookIdIsNotValid("invalid book id ");
	}
	public Book retrieveBook(Book bull) {
		throw new LengthTitleException("book title should be less than 30 ch");
	}
	public Book retrieveBook2(Book bull) {
		throw new yearOfPublishException("year of publish greater than 2022");
	}
	public Book createBook(Book bull) {
		throw new BookIdIsNotPresentException("invalid book id is present");
	}

}
