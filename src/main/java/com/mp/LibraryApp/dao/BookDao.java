package com.mp.LibraryApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mp.LibraryApp.Entity.Book;


@Repository
public interface BookDao extends JpaRepository<Book, Integer> {
	
	public String deleteBytitleOrAuthorName(String title,String authorName);
	
	public List<Book>  findBytitleAndAuthorName(String title,String authorName);
}
