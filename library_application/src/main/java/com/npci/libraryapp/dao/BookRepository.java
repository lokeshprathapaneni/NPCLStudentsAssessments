package com.npci.libraryapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npci.libraryapp.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	public List<Book> findByTitleAndAuthorName(String title, String authorName);

	public void deleteByTitleOrAuthorName(String title, String authorName);

}
