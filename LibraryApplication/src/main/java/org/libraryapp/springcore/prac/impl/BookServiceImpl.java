package org.libraryapp.springcore.prac.impl;

import java.util.List;
import java.util.Optional;

import org.libraryapp.springcore.prac.bookclass.Book;
import org.libraryapp.springcore.prac.bookdao.BookDao;
import org.libraryapp.springcore.prac.exception.BookIdIsNotPresentException;
import org.libraryapp.springcore.prac.exception.BookIdIsNotValid;
import org.libraryapp.springcore.prac.exception.LengthTitleException;
import org.libraryapp.springcore.prac.exception.YearOfPublishException;
import org.libraryapp.springcore.prac.interfaces.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class BookServiceImpl implements IBookService {
	@Autowired
	BookDao bDao;
	
	Logger LOGGER=LoggerFactory.getLogger("BookServiceImpl.class");

	@Override
	public Book getBook(Integer bookId) {
		LOGGER.info("retrieving book{}", bookId);
		Optional<Book> bookRecord=bDao.findById(bookId);
		if(!bookRecord.isPresent()) {
			throw new  BookIdIsNotPresentException("bookID doesnt exist in db");
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

	@Override
	public String createBook(Book book) {
		bDao.save(book);
		return "Save Successfully";
	}

	@Override
	public String updateBook(Book book) {
		bDao.save(book);
		return "update successfully";
	}

	@Override
	public String updateAuthorName(Book book) {
		if(book.getBookId()==null) {
	           throw new BookIdIsNotValid("bookId is mandatory");
       }
       Optional<Book> bookOp=bDao.findById(book.getBookId());
       Book ad=bookOp.get();
       ad.setAuthorName(book.getAuthorName());
       bDao.save(ad);
	   return "update successfully";
	}

	@Override
	public String deleteBookId(Integer bookId) {
		bDao.deleteByBookId(bookId);
		return "Deleted BookId";
	}

	@Override
	public List<Book> getTitleAndAuthor(String title, String authorName) {
		List<Book> b=bDao.findByTitleAndAuthorName(title, authorName);
		return b;
	}

	@Override
	public String deleteBookId(String title, String authorName) {
		bDao.deleteByTitleOrAuthorName(title, authorName);
		return "Deleted Title or AuthorName";
	}

}
