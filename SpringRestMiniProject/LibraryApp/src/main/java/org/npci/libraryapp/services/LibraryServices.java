package org.npci.libraryapp.services;

import java.util.List;
import java.util.Optional;


import org.npci.libraryapp.dao.LibraryDao;
import org.npci.libraryapp.entity.Book;
import org.npci.libraryapp.exceptions.BookIdMandatoryException;
import org.npci.libraryapp.exceptions.InvalidBookIdException;
import org.npci.libraryapp.exceptions.InvalidPublishYearException;
import org.npci.libraryapp.exceptions.TitleLengthInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class LibraryServices implements ILibraryService {

	@Autowired
	LibraryDao dao;
	
	Logger LOGGER = LoggerFactory.getLogger("LibraryServices.class");
	
	public String create(Book b) {
		
		LOGGER.info("Saving bookId:{}", b.getBookId());
		if(b.getTitle().length()>30) {
			throw new TitleLengthInvalidException("Title should be less than 30 characters");
		}
		if(b.getYearOfPublish()>2022) {
			throw new InvalidPublishYearException("Publish year should be less than or equal to 2022");
		}
		dao.save(b);
		LOGGER.info("Book id:{} saved", b.getBookId());
		return "book saved";
	}
	public void updateFields(Book b) {
		dao.save(b);
		LOGGER.info("Details for bookId:{} updated", b.getBookId());
	}
	public void updateAuthor(Book b) {
		if(b.getBookId() == 0) {
			throw new BookIdMandatoryException("Book id is mandatory");
		}
		LOGGER.info("Updating author name for bookId:{}", b.getBookId());
		Optional<Book> findById = dao.findById(b.getBookId());
		Book book = findById.get();
		book.setAuthorName(b.getAuthorName());
		dao.save(book);
		LOGGER.info("Author name for bookId:{} has been updated with:{}", book.getBookId(),book.getAuthorName());
	}
	public Book bookByID(Integer id) {
		Optional<Book> findById = dao.findById(id);
		Book book = findById.get();
		if(book.equals(null)) {
			throw new InvalidBookIdException("book id not present in database");
		}
		LOGGER.info("Details of bookId:{}{}", book.getBookId(),book);
		return book;
	}
	public void byIdDelete(Integer id) {
		dao.deleteById(id);
		LOGGER.info("BookId:{} has been deleted", id);
	}
	public List<Book> byTitleAndAuthorName(String title, String an) {
		List<Book> findByTitleAndAuthorName = dao.findByTitleAndAuthorName(title, an);
		LOGGER.info("Found with title:{} and author:{}", title, an);
		return findByTitleAndAuthorName;
	}
	public void byTitleOrAuthorNameDelete(String title, String an) {
		dao.deleteByTitleOrAuthorName(title, an);
		LOGGER.info("Book with title:{} or author:{} has been deleted", title,an);
	} 
}
