package org.sujitmaity.LibraryApplication.Miniproject.imp;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sujitmaity.LibraryApplication.Miniproject.BookClacc.BookClass;
import org.sujitmaity.LibraryApplication.Miniproject.BookDAO.BookDAO;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.BookIdIsInvalid;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.BookIdIsNotPresentException;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.LengthOfTitleException;
import org.sujitmaity.LibraryApplication.Miniproject.Exception.YearOfPublishException;
import org.sujitmaity.LibraryApplication.Miniproject.interfaces.IBookService;

@Service
public class BookServiceImp implements IBookService{
	@Autowired
	BookDAO bookDao;

	Logger LOGGER=LoggerFactory.getLogger("BookServiceImp.class");

	@Override
	public BookClass getBook(Integer bookId) {
		LOGGER.info("retriving book {}",bookId);
		Optional<BookClass> booRecord=bookDao.findById(bookId);
		if(!booRecord.isPresent()){
			throw new BookIdIsNotPresentException("Book Id is not present in Database Server");
		}
		BookClass bk=booRecord.get();
		if(bk.getTitle().length()>30) {
			throw new LengthOfTitleException("Book Title Should be less than 30 Characters");
		}
		if(bk.getYearOfPublish()>2022){
			throw new YearOfPublishException("Year of published should be less than or equal to current year.");
		} 
		LOGGER.info("retrieving bookClass {}", booRecord.get());
		return  booRecord.get();
	}

	@Override
	public String createBook(BookClass book) {
		bookDao.save(book);
		return "Book Save Successfully";
	}

	@Override
	public String updateBook(BookClass book) {
		bookDao.save(book);
		return "Book Update Successfully";
	}

	@Override
	public String updateAuthorName(BookClass book) {
		if(book.getBookId()==null) {
			throw new BookIdIsInvalid("Book Id is Mandatory to Save Data in Server.");
		}
		Optional<BookClass> bookput = bookDao.findById(book.getBookId());
		BookClass bk = bookput.get();
		bk.setAuthorName(book.getAuthorName());
		bookDao.save(bk);
		return "UpdateAuthorName Successfully";
	}

	@Override
	public String deleteBookId(Integer bookId) {
		bookDao.deleteByBookId(bookId);
		return "Delete BookId Successfully";
	}

	@Override
	public String deleteBook(String title, String authorName) {
		bookDao.deleteByTitleOrAuthorName(title, authorName);
		return "Delete Title Or AuthoeName Successfully";
	}

	@Override
	public List<BookClass> getTitleAndAuthor(String title, String authorName) {
		List<BookClass> boo= bookDao.findByTitleAndAuthorName(title, authorName);
		return boo;
	}

}

