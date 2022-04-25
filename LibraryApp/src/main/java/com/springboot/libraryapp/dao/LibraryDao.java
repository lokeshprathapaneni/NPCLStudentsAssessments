package com.springboot.libraryapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.springboot.libraryapp.entity.Library;

@Repository
public interface LibraryDao extends JpaRepository<Library, Integer> {

	public void deleteById(Integer bookId);
	
	public List<Library> findByTitleAndAuthorName(String s1, String s2);
	
	public void deleteByTitleOrAuthorName(String t,String a);
}
