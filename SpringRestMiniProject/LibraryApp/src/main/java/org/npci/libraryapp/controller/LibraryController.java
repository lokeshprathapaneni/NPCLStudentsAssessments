package org.npci.libraryapp.controller;

import java.util.List;
import java.util.Optional;

import org.npci.libraryapp.dao.LibraryDao;
import org.npci.libraryapp.entity.Book;
import org.npci.libraryapp.exceptions.BookIdMandatoryException;
import org.npci.libraryapp.exceptions.InvalidBookIdException;
import org.npci.libraryapp.exceptions.InvalidPublishYearException;
import org.npci.libraryapp.exceptions.TitleLengthInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("save")
	public String createBook(@RequestBody Book b) {
		
		if(b.getTitle().length()>30) {
			throw new TitleLengthInvalidException("Title should be less than 30 characters");
		}
		if(b.getYearOfPublish()>2022) {
			throw new InvalidPublishYearException("Publish year should be less than or equal to 2022");
		}
		Book save = dao.save(b);
		return "Book "+save.getBookId()+" saved";
	}
	
	@PutMapping("/library/b")
	public String updateAllFields(@RequestBody Book b) {
		dao.save(b);
		return "All fields updated";
	}
	
	@PatchMapping("/library/name")
	public String updateAuthorName(@RequestBody Book b) {
		if(b.getBookId() == 0) {
			throw new BookIdMandatoryException("Book id is mandatory");
		}
		Optional<Book> findById = dao.findById(b.getBookId());
		Book book = findById.get();
		book.setAuthorName(b.getAuthorName());
		dao.save(book);
		return "author name updated for: "+b.getBookId();
	}
	
	@GetMapping("/library/{bookId}")
	public Book getBook(@PathVariable("bookId") Integer id) {
		
		Optional<Book> findById = dao.findById(id);
		if(findById.equals(null)) {
			throw new InvalidBookIdException("book id not present in database");
		}
		return findById.get();
	}
	
	@DeleteMapping("/delete")
	public String deleteBookById(@RequestBody Integer id) {
		
		dao.deleteById(id);
		return "deleted according to id";
	}
	
	@GetMapping("/lookByTitleAndAuthorName/{title}/{author}")
	public List<Book> findBook(@PathVariable("title") String t, @PathVariable("author") String an) {
		List<Book> findByTitleAndAuthorName = dao.findByTitleAndAuthorName(t, an);
		return findByTitleAndAuthorName;
	}
	
	@DeleteMapping("/deleteByTitleOrAuthorName/{title}/{author}")
	public String deleteByTitleOrAuthorName(@PathVariable("title") String t, @PathVariable("author") String an) {
		dao.deleteByTitleOrAuthorName(t, an);
		return "deleted by Title Or AuthorName";
	}

}
