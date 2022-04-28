package com.mp.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mp.library.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer>{
	
	public void deleteByTitleOrAuthorName(String t, String a);
	
	public List<Book> findByTitleAndAuthorName(String t, String a);

}
