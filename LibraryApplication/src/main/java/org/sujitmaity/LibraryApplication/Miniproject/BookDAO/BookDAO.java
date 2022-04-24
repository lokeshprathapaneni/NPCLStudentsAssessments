package org.sujitmaity.LibraryApplication.Miniproject.BookDAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sujitmaity.LibraryApplication.Miniproject.BookClacc.BookClass;

@Repository
public interface BookDAO extends JpaRepository<BookClass, Integer>{

	public void deleteByBookId(Integer n1);
	
	public List<BookClass> findByTitleAndAuthorName(String n2, String n3);
	
	public void deleteByTitleOrAuthorName(String n4, String n5);
	
}
