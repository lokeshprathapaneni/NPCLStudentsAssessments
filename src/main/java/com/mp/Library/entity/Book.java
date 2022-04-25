package com.mp.Library.entity;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
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
public class Book {

	@Id
	@Column(name = "bookId")
	private Integer bookId;
	@Column(name = "title")
	private String title;
	@Column(name = "authorName")
	private String authorName;
	@Column(name = "yearOfPublish")
	private Integer yearOfPublish;
}

	

   