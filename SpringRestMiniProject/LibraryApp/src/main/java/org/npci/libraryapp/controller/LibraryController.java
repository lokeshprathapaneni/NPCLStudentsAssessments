package org.npci.libraryapp.controller;

import java.util.List;
import java.util.Optional;

import org.npci.libraryapp.dao.LibraryDao;
import org.npci.libraryapp.entity.Book;
import org.npci.libraryapp.exceptions.BookIdMandatoryException;
import org.npci.libraryapp.exceptions.InvalidBookIdException;
import org.npci.libraryapp.exceptions.InvalidPublishYearException;
import org.npci.libraryapp.exceptions.TitleLengthInvalidException;
import org.npci.libraryapp.services.LibraryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lib")
public class LibraryController {

	@Autowired
	LibraryDao dao;
	
	@Autowired
	LibraryServices libraryServices;
	
	@PostMapping("save")
	public ResponseEntity<String> createBook(@RequestBody Book b) {
		
		Book book = libraryServices.create(b);
//		if(b.getTitle().length()>30) {
//			throw new TitleLengthInvalidException("Title should be less than 30 characters");
//		}
//		if(b.getYearOfPublish()>2022) {
//			throw new InvalidPublishYearException("Publish year should be less than or equal to 2022");
//		}
//		Book save = dao.save(b);
		return new ResponseEntity<String>("Book "+book.getBookId()+" saved",HttpStatus.CREATED);
	}
	
	@PutMapping("/library/b")
	public ResponseEntity<String> updateAllFields(@RequestBody Book b) {
//		dao.save(b);
		libraryServices.updateFields(b);
		return new ResponseEntity<String>("All fields updated", HttpStatus.OK);
	}
	
	@PatchMapping("/library/name")
	public ResponseEntity<String> updateAuthorName(@RequestBody Book b) {
//		if(b.getBookId() == 0) {
//			throw new BookIdMandatoryException("Book id is mandatory");
//		}
//		Optional<Book> findById = dao.findById(b.getBookId());
//		Book book = findById.get();
//		book.setAuthorName(b.getAuthorName());
//		dao.save(book);
		libraryServices.updateAuthor(b);
		return new ResponseEntity<String>("author name updated for: "+b.getBookId(),HttpStatus.OK);
	}
	
	@GetMapping("/library/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable("bookId") Integer id) {
		
//		Optional<Book> findById = dao.findById(id);
//		Book book = findById.get();
//		if(book.equals(null)) {
//			throw new InvalidBookIdException("book id not present in database");
//		}
		Book bookByID = libraryServices.bookByID(id);
		return new ResponseEntity<Book>(bookByID,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<String> deleteBookById(@PathVariable("bookId") Integer id) {
		
//		dao.deleteById(id);
		libraryServices.byIdDelete(id);
		return new ResponseEntity<String>("deleted according to id",HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/lookByTitleAndAuthorName/{title}/{author}")
	public ResponseEntity<List<Book>> findBookByTitleAndAuthorName(@PathVariable("title") String t, @PathVariable("author") String an) {
//		List<Book> findByTitleAndAuthorName = dao.findByTitleAndAuthorName(t, an);
		List<Book> byTitleAndAuthorName = libraryServices.byTitleAndAuthorName(t, an);
		return new ResponseEntity<List<Book>>(byTitleAndAuthorName,HttpStatus.OK);
	}
	
	@DeleteMapping("/delByTitleOrAuthorName/{title}/{author}")
	public ResponseEntity<String> deleteByTitleOrAuthorName(@PathVariable("title") String t, @PathVariable("author") String an) {
//		dao.deleteByTitleOrAuthorName(t, an);
		libraryServices.byTitleOrAuthorNameDelete(t, an);
		return new ResponseEntity<String>("deleted by Title Or AuthorName",HttpStatus.NO_CONTENT);
	}

}
