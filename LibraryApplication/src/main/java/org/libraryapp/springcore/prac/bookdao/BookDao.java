package org.libraryapp.springcore.prac.bookdao;

import java.util.List;

import org.libraryapp.springcore.prac.bookclass.Book;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BookDao extends JpaRepository<Book,Integer> {
	
	public void deleteByBookId(Integer n1);
	
	public List<Book> findByTitleAndAuthorName(String n2, String n3);
	
	
	public void deleteByTitleOrAuthorName(String n4, String n5);

}

