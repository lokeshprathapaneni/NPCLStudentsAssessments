package com.springboot.libraryapp.controller;

import java.util.List;

import javax.transaction.Transactional;

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

import com.springboot.libraryapp.entity.Library;
import com.springboot.libraryapp.services.ILibraryServices;
import com.springboot.libraryapp.services.LibraryServices;

@RestController
@RequestMapping("/lib")
public class LibraryController {

	
	@Autowired
	private ILibraryServices libraryServices;
	
	@PostMapping("/lib1")
	public ResponseEntity<String> addNewBook(@RequestBody Library lib) {

		Library l=libraryServices.addNewBook(lib);
		return new ResponseEntity<String>("Book"+l.getTitle()+"added to library",HttpStatus.CREATED);
		
	}
	
	@PutMapping("/lib2")
	public ResponseEntity<String> updateBook(@RequestBody Library lib) {
		
		Library l=libraryServices.updateBook(lib);
		return new ResponseEntity<String>(l.getTitle()+"Updated",HttpStatus.ACCEPTED);
	}

	@PatchMapping("/lib3")
	public ResponseEntity<String>  updateAuthorName(@RequestBody Library lib) {
		Library l=libraryServices.updateAuthorName(lib);
		return new ResponseEntity<String>("Author name of"+lib.getBookId()+"updated",HttpStatus.ACCEPTED);
	}

	@GetMapping("/lib4/{bookId}")
	public ResponseEntity<Library> getBook(@PathVariable("bookId") Integer bookId) {
		Library l=libraryServices.getBook(bookId);
		return new ResponseEntity<Library>(l,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/lib5/{id}")
	public ResponseEntity<String> delById(@PathVariable("id") Integer bookId) {
		libraryServices.delById(bookId);
		return new ResponseEntity<String>("Book deleted",HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping("/lib6/{title}/{authorName}")
	public ResponseEntity<List<Library>> getBookByTitleAndAuthor(@PathVariable("title") String title,@PathVariable("authorName") String authorName){
		List<Library> l=libraryServices.getBookByTitleAndAuthor(title, authorName);
		return new ResponseEntity<List<Library>>(l,HttpStatus.OK);
	}
	
	@DeleteMapping("/lib7/{t}/{a}")
	@Transactional
	public ResponseEntity<String> deleteBook(@PathVariable("t") String title,@PathVariable("a") String authorName) {
		libraryServices.deleteBook(title, authorName);
		return new ResponseEntity<String>("Book deleted",HttpStatus.NO_CONTENT);
		
	}
	
	
	
}
