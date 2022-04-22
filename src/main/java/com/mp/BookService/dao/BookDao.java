package com.mp.BookService.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mp.BookService.entity.Book;

public interface BookDao extends JpaRepository<Book, Integer> {

	public List<Book> findBytitleAndauthorName(String title, String authorName);
	
	public static  void deleteByTitleOrAuthorName(String title, String authorName) {
		// TODO Auto-generated method stub
		
	}

}