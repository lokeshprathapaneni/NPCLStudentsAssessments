package com.mp.libraryapp.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mp.libraryapp.entity.Book;


@Repository
public interface BookDao extends JpaRepository<Book, Integer>
{


	public Optional<Book> findByTitleAndAuthorName(String title, String authorName);

	public void deleteByTitleOrAuthorName(String title, String authorName);

}
