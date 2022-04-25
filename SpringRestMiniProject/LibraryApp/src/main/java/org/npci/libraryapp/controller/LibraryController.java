package org.npci.libraryapp.controller;

import java.util.List;
import java.util.Optional;

import org.npci.libraryapp.dao.LibraryDao;
import org.npci.libraryapp.entity.Book;
import org.npci.libraryapp.exceptions.BookIdMandatoryException;
import org.npci.libraryapp.exceptions.InvalidBookIdException;
import org.npci.libraryapp.exceptions.InvalidPublishYearException;
import org.npci.libraryapp.exceptions.TitleLengthInvalidException;
import org.npci.libraryapp.services.ILibraryService;
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
	ILibraryService iLibraryService;
	
	@PostMapping("/save")
	public ResponseEntity<String> createBook(@RequestBody Book b) {
		
		String create = iLibraryService.create(b);		
		return new ResponseEntity<String>(create+b.getBookId(),HttpStatus.CREATED);
	}
	
	@PutMapping("/library/b")
	public ResponseEntity<String> updateAllFields(@RequestBody Book b) {
		iLibraryService.updateFields(b);
		return new ResponseEntity<String>("All fields updated", HttpStatus.OK);
	}
	
	@PatchMapping("/library/name")
	public ResponseEntity<String> updateAuthorName(@RequestBody Book b) {

		iLibraryService.updateAuthor(b);
		return new ResponseEntity<String>("author name updated for: "+b.getBookId(),HttpStatus.OK);
	}
	
	@GetMapping("/library/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable("bookId") Integer id) {
		

		Book bookByID = iLibraryService.bookByID(id);
		return new ResponseEntity<Book>(bookByID,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<String> deleteBookById(@PathVariable("bookId") Integer id) {
		

		iLibraryService.byIdDelete(id);
		return new ResponseEntity<String>("deleted according to id",HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/lookByTitleAndAuthorName/{title}/{author}")
	public ResponseEntity<List<Book>> findBookByTitleAndAuthorName(@PathVariable("title") String t, @PathVariable("author") String an) {

		List<Book> byTitleAndAuthorName = iLibraryService.byTitleAndAuthorName(t, an);
		return new ResponseEntity<List<Book>>(byTitleAndAuthorName,HttpStatus.OK);
	}
	
	@DeleteMapping("/delByTitleOrAuthorName/{title}/{author}")
	public ResponseEntity<String> deleteByTitleOrAuthorName(@PathVariable("title") String t, @PathVariable("author") String an) {

		iLibraryService.byTitleOrAuthorNameDelete(t, an);
		return new ResponseEntity<String>("deleted by Title Or AuthorName",HttpStatus.NO_CONTENT);
	}

}
