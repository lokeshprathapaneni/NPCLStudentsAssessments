package com.mp.Library.services;

import com.mp.Library.entity.Book;

import java.util.List;

public interface IBookservices {

	public Book saveBookDetails(Book book);
	public Book updateBookDetails(Book book);
	public Book updateAuthorName(Book book);
	public Book getBookDetails(Integer bookId);
	public String deleteBook(Integer bookId);
	public List<Book> getbookbytitleandauthor(String title, String authorName);
    public String deletebytitleorauthorname(String title, String authorName);
	

}
