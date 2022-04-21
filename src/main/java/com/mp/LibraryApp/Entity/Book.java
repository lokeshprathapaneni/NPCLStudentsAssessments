package com.mp.LibraryApp.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Book")
public class Book {
	
	@Id
	@Column(name="bookId")
	Integer bookId;
	
	@Column(name="title")
	String title;
	
	@Column(name="authorName")
	String authorName;
	
	@Column(name="yearOFPublish")
	Integer yearOFPublish;

	public Book() {
		
	}

	public Book(Integer bookId, String title, String authorName, Integer yearOFPublish) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.authorName = authorName;
		this.yearOFPublish = yearOFPublish;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Integer getYearOFPublish() {
		return yearOFPublish;
	}

	public void setYearOFPublish(Integer yearOFPublish) {
		this.yearOFPublish = yearOFPublish;
	}
	
	
	
	

}
