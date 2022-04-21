package com.npci.spring_mini_project.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.spring_mini_project.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByTitleAndAuthorName(String title, String authorName);
	
	public void deleteByTitleOrAuthorName(String title, String authorName);

}
