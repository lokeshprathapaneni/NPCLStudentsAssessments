package com.mp.Library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mp.Library.entity.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer>{

	public List<Book> findbytitleandauthorname(String title, String authorName);
	
	public void deletebytitleorauthorname(String title, String authorname);

}