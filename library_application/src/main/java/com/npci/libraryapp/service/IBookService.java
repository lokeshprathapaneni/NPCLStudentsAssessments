package com.npci.libraryapp.service;

import java.util.List;

import com.npci.libraryapp.entity.Book;

public interface IBookService {

	public String saveBookDetails(Book book);

	public Book updateBookDetails(Book book);

	public Book updateAuthorName(Book book);

	public Book fetchBookforId(Integer bookId);

	public String deleteBookByid(Integer bookId);

	public List<Book> getBookByTitleAndAuthor(Book book);

	public String delByTitleOrAuthorName(Book book);

}
