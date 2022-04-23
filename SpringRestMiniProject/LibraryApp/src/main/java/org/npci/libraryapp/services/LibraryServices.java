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

@Service
public class LibraryServices {

	@Autowired
	LibraryDao dao;
	
	public String create(Book b) {
		
		if(b.getTitle().length()>30) {
			throw new TitleLengthInvalidException("Title should be less than 30 characters");
		}
		if(b.getYearOfPublish()>2022) {
			throw new InvalidPublishYearException("Publish year should be less than or equal to 2022");
		}
		dao.save(b);
		return "book saved";
	}
	public void updateFields(Book b) {
		dao.save(b);
	}
	public void updateAuthor(Book b) {
		if(b.getBookId() == 0) {
			throw new BookIdMandatoryException("Book id is mandatory");
		}
		Optional<Book> findById = dao.findById(b.getBookId());
		Book book = findById.get();
		book.setAuthorName(b.getAuthorName());
		dao.save(book);
	}
	public Book bookByID(Integer id) {
		Optional<Book> findById = dao.findById(id);
		Book book = findById.get();
		if(book.equals(null)) {
			throw new InvalidBookIdException("book id not present in database");
		}
		return book;
	}
	public void byIdDelete(Integer id) {
		dao.deleteById(id);
	}
	public List<Book> byTitleAndAuthorName(String title, String an) {
		List<Book> findByTitleAndAuthorName = dao.findByTitleAndAuthorName(title, an);
		return findByTitleAndAuthorName;
	}
	public void byTitleOrAuthorNameDelete(String title, String an) {
		dao.deleteByTitleOrAuthorName(title, an);
	} 
}
