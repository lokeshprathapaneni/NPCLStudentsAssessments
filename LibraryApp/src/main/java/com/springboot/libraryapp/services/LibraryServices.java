package com.springboot.libraryapp.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.libraryapp.dao.LibraryDao;
import com.springboot.libraryapp.entity.Library;
import com.springboot.libraryapp.exceptions.BookIdNotPresentException;
import com.springboot.libraryapp.exceptions.CharacterLengthException;
import com.springboot.libraryapp.exceptions.InvalidBookIdException;
import com.springboot.libraryapp.exceptions.InvalidYearException;

@Service
public class LibraryServices {
	
	@Autowired
	private LibraryDao dao;
	
	Logger LOGGER = LoggerFactory.getLogger("BookServices.class");
	
	public Library addNewBook(Library lib){
		LOGGER.info("Adding book of Id: {}",lib.getBookId());
		if(lib.getYearOFPublish()>2022) {
			throw new InvalidYearException("year of publish should be less than or equals to current year");
		}
		if(lib.getTitle().length()>30) {
			throw new CharacterLengthException("Book title should be less than 30 charecters ");
		}
		Library l=dao.save(lib);
		LOGGER.info("Book details for Book Id: {} saved.",lib.getBookId());
		return l;

	}
	
	public Library updateBook(Library lib) {
		LOGGER.info("Updating Book details for Book Id: {}.",lib.getBookId());
		dao.save(lib);
		LOGGER.info("Book details for Book Id: {} updated.",lib.getBookId());
		return lib;
	}
	
	public Library updateAuthorName(Library lib) {
		LOGGER.info("Updating Author Name for Book Id: {}.",lib.getBookId());
		if(lib.getBookId()==null) {
			throw new BookIdNotPresentException("BookId is mandatory");
		}
		Optional<Library> opt = dao.findById(lib.getBookId());
		Library li = opt.get();
		li.setAuthorName(lib.getAuthorName());
		dao.save(li);
		LOGGER.info("Author Name for Book Id: {} updated.",lib.getBookId());
		return lib;
	}
	
	public Library getBook(Integer bookId) {
		LOGGER.info("Getting Details for Book Id: {}.",bookId);
		Optional<Library> li = dao.findById(bookId);
		if(!li.isPresent()) {
			throw new InvalidBookIdException("BookID doesnt exist in db");
		}
		LOGGER.info(" Details for Book Id: {}.",bookId);
		return li.get();
	}
	
	public String delById(Integer bookId) {
		LOGGER.info("Deleting Details of Book for Book Id: {}.",bookId);
		dao.deleteById(bookId);
		LOGGER.info("Book Details Deleted for Book Id: {}.",bookId);
		return "Book deleted";
	}
	
	public List<Library> getBookByTitleAndAuthor(String title, String authorName){
		LOGGER.info("Finding Details of Book with Title: '{}' and Author: '{}'.",title,authorName);
		List<Library> li=dao.findByTitleAndAuthorName(title, authorName);
		LOGGER.info(" Book with Title: '{}' and Author: '{}' found.",title,authorName);
		return li;
	}
	
	public String deleteBook(String title,String authorName) {
		LOGGER.info("Deleting Details of Book with Title: '{}' or Author: '{}'.",title,authorName);
		dao.deleteByTitleOrAuthorName(title,authorName);
		LOGGER.info(" Book with Title: '{}' or Author: '{}' deleted.",title,authorName);
		return "Book deleted";
	}
	

}
