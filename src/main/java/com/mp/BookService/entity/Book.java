package com.mp.BookService.entity;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
import javax.persistence.Table;  

@Entity
@Table
public class Book {

    @Id
    @Column
   private int bookid;
    
    @Column
    private String title ;
    
    @Column
    private String authorName ;
    
    @Column
    private int yearOFPublish;
    
    public Book() {
    }

    public Book(int bookid, String title, String authorName, int yearOFPublish) {
       super();
    	this.bookid = bookid;
        this.title = title;
        this.authorName = authorName;
        this.yearOFPublish= yearOFPublish;
    }

   

    public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
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

	public int getYearOFPublish() {
		return yearOFPublish;
	}

	public void setYearOFPublish(int yearOFPublish) {
		this.yearOFPublish = yearOFPublish;
	}
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", title=" + title + ", authorName=" + authorName + ", yearOfPublish="
				+ yearOFPublish + "]";
	}
}

	

   