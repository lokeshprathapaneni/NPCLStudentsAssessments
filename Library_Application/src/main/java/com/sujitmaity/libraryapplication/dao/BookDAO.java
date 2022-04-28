package com.sujitmaity.libraryapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.sujitmaity.libraryapplication.entity.Book;

@Repository
public interface BookDAO extends JpaRepository<Book, Integer>{

	public void deleteByBookId(Integer n1);
	
	public List<Book> findByTitleAndAuthorName(String n2, String n3);
	
	public void deleteByTitleOrAuthorName(String n4, String n5);

}
