package org.npci.libraryapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "library")
public class Book {

	@Id
	@Column(name = "id")
	Integer bookId;
	@Column(name = "title")
	String title;
	@Column(name = "author")
	String authorName;
	@Column(name = "yop")
	Integer yearOfPublish;
	
	public Book() {
		
	}
	
	public Book(Integer bookId, String title, String authorName, Integer yearOfPublish) {
		this.bookId = bookId;
		this.title = title;
		this.authorName = authorName;
		this.yearOfPublish = yearOfPublish;
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

	public Integer getYearOfPublish() {
		return yearOfPublish;
	}

	public void setYearOfPublish(Integer yearOfPublish) {
		this.yearOfPublish = yearOfPublish;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", authorName=" + authorName + ", yearOfPublish="
				+ yearOfPublish + "]";
	}
	
	
}
