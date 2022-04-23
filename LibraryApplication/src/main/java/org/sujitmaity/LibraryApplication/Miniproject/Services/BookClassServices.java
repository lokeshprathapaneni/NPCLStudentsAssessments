package org.sujitmaity.LibraryApplication.Miniproject.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sujitmaity.LibraryApplication.Miniproject.BookClacc.BookClass;
import org.sujitmaity.LibraryApplication.Miniproject.BookDAO.BookDAO;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.BookIdIsInvalid;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.BookIdIsNotPresentException;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.LengthOfTitleException;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.YearOfPublishException;

@Service
public class BookClassServices {
	
	@Autowired
	BookDAO bookDAO;

	public BookClass createBook(Optional<BookClass> booRecord) {
		throw new BookIdIsInvalid("Book Id is Not Present in Database");
	}
	
	public BookClass createBook1(BookClass book) {
		throw new LengthOfTitleException("Book Title Should Less Than 30 Characters.");
	}
	
	public BookClass createBook2(BookClass book) {
		throw new YearOfPublishException("year of publish should be less than or equals to current year.");
	}
	
	public BookClass createBook3(BookClass book) {
		throw new BookIdIsNotPresentException("BookId Is Mandatory");
	}
}
