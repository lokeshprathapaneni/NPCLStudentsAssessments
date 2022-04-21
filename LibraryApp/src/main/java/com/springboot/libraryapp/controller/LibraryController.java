package com.springboot.libraryapp.controller;

import java.util.Optional;

import javax.transaction.Transactional;

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

import com.springboot.libraryapp.dao.LibraryDao;
import com.springboot.libraryapp.entity.Library;
import com.springboot.libraryapp.exceptions.BookIdNotPresentException;
import com.springboot.libraryapp.exceptions.CharacterLengthException;
import com.springboot.libraryapp.exceptions.InvalidBookIdException;
import com.springboot.libraryapp.exceptions.InvalidYearException;

import java.util.List;

@RestController
@RequestMapping("/lib")
public class LibraryController {

	@Autowired
	LibraryDao dao;
	
	@PostMapping("/lib1")
	public String addNewBook(@RequestBody Library lib) {
		
		if(lib.getYearOFPublish()>2022) {
			throw new InvalidYearException("year of publish should be less than or equals to current year");
		}
		if(lib.getTitle().length()>30) {
			throw new CharacterLengthException("Book title should be less than 30 charecters ");
		}
		Library l=dao.save(lib);
		return "Book"+l.getTitle()+"added to library";
	}
	
	@PutMapping("/lib2")
	public String updateBook(@RequestBody Library lib) {
		dao.save(lib);
		return lib.getTitle()+"Updated";
	}

	@PatchMapping("/lib3")
	public String updateAuthorName(@RequestBody Library lib) {
		if(lib.getBookId()==null) {
			throw new BookIdNotPresentException("BookId is mandatory");
		}
		Optional<Library> opt = dao.findById(lib.getBookId());
		Library li = opt.get();
		li.setAuthorName(lib.getAuthorName());
		dao.save(li);
		return "Author name of"+lib.getBookId()+"updated";
	}

	@GetMapping("/lib4/{bookId}")
	public Library getBook(@PathVariable("bookId") Integer bookId) {
		Optional<Library> li = dao.findById(bookId);
		if(!li.isPresent()) {
			throw new InvalidBookIdException("BookID doesnt exist in db");
		}
		return li.get();
	}
	
	@DeleteMapping("/lib5/{id}")
	public String delById(@PathVariable("id") Integer bookId) {
		dao.deleteById(bookId);
		return "Book deleted";
	}
	
	
	@GetMapping("/lib6/{title}/{authorName}")
	public List<Library> getBookByTitleAndAuthor(@PathVariable("title") String title,@PathVariable("authorName") String authorName){
		List<Library> li=dao.findByTitleAndAuthorName(title, authorName);
		return li;
	}
	
	@DeleteMapping("/lib7/{t}/{a}")
	@Transactional
	public String deleteBook(@PathVariable("t") String title,@PathVariable("a") String authorName) {
		dao.deleteByTitleOrAuthorName(title,authorName);
		return "Book deleted";
	}
	
	
	
}
