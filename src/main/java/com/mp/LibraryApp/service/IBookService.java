package com.mp.LibraryApp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mp.LibraryApp.Entity.Book;
import com.mp.LibraryApp.dao.BookDao;



public interface IBookService {
	 
	
	
	 Book getBook( Integer bookId) ;
	 String saveBook( Book bk);
	//Updating the book details
	 Book bookUpdate(Book bk);
	//updating AuthorName
	 Book bookUpdatebyId( Book bk);
	 String removeBook( Integer bookId);
	 String removesBook( String title, String authorName);
	 List<Book> getBook( String title, String authorName);

}
