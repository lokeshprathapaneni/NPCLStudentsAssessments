package com.sujitmaity.libraryapplication.interfaceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sujitmaity.libraryapplication.dao.BookDAO;
import com.sujitmaity.libraryapplication.entity.Book;
import com.sujitmaity.libraryapplication.exception.BookIdIsInvalid;
import com.sujitmaity.libraryapplication.exception.BookIdIsNotPresentException;
import com.sujitmaity.libraryapplication.exception.LengthOfTitleException;
import com.sujitmaity.libraryapplication.exception.YearOfPublishException;

@Service
public class BookServiceImp implements IBookService{
	
	@Autowired
	BookDAO bookDao;
	
	Logger LOGGER=LoggerFactory.getLogger("BookServiceImp.class");

	@Override
	public Book getBook(Integer bookId) {
		LOGGER.info("retriving book {}",bookId);
		Optional<Book> booRecord=bookDao.findById(bookId);
		if(!booRecord.isPresent()){
			throw new BookIdIsNotPresentException("Book Id is not present in Database Server");
		}
		Book bk=booRecord.get();
		if(bk.getTitle().length()>30) {
			throw new LengthOfTitleException("Book Title Should be less than 30 Characters");
		}
		if(bk.getYearOfPublish()>2022){
			throw new YearOfPublishException("Year of published should be less than or equal to current year");
		} 
		LOGGER.info("retrieving bookClass {}", booRecord.get());
		return  booRecord.get();
	}

	@Override
	public String createBook(Book book) {
		bookDao.save(book);
		return "Book Save Successfully";
	}

	@Override
	public String updateBook(Book book) {
		bookDao.save(book);
		return "Book Update Successfully";
	}

	@Override
	public String updateAuthorName(Book book) {
		if(book.getBookId()==null) {
			throw new BookIdIsInvalid("Book Id is Mandatory to Save Data in Server");
		}
		Optional<Book> bookput = bookDao.findById(book.getBookId());
		Book bk = bookput.get();
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
	public List<Book> getTitleAndAuthor(String title, String authorName) {
		List<Book> boo= bookDao.findByTitleAndAuthorName(title, authorName);
		return boo;
	}
}
