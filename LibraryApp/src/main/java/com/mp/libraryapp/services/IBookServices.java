package com.mp.libraryapp.services;

import com.mp.libraryapp.entity.Book;

public interface IBookServices {

	Book createBook(Book book);
	Book updateBook(Book book);
	Book updateAuthorName(Book book);
	Book getBook(Integer bookId);
	String deleteBook(Integer bookId);
	Book getBookByTitleAndAuthor(String title,String authorName);
	String deleteByTitleOrAuthorName(String title,String authorName);
}
