package org.npci.libraryapp.dao;

import java.util.List;

import org.npci.libraryapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryDao extends JpaRepository<Book, Integer>{

	
	public List<Book> findByTitleAndAuthorName(String title, String name);
	public void deleteByTitleOrAuthorName(String t, String n);
}
