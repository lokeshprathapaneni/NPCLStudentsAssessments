package com.mp.libraryapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Book {

	@Id
	@Column(name="BookId")
	Integer bookId;

	@Column(name="TITLE")
	String title;

	@Column(name="AUTHORNAME")
	String authorName;

	@Column(name="YearofPublish")
	Integer yearOfPublish;

/*

	public Book() {
	}

	public Book(Integer bookId, String title, String authorName, Integer yearOfPublish) {
		super();
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
		return "Book [BookId=" + bookId + ", Title=" + title + ", authorName=" + authorName + ", yearOfPublish="
				+ yearOfPublish + "]";
	}

*/
	
}