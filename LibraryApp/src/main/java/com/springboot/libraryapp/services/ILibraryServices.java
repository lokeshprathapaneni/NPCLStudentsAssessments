package com.springboot.libraryapp.services;

import java.util.List;

import com.springboot.libraryapp.entity.Library;

public interface ILibraryServices {

	Library addNewBook(Library lib);
	Library updateBook(Library lib);
	Library updateAuthorName(Library lib);
	Library getBook(Integer bookId);
	String delById(Integer bookId);
	List<Library> getBookByTitleAndAuthor(String title, String authorName);
	String deleteBook(String title,String authorName);
}
