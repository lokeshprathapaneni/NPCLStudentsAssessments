package com.mp.library.entity;

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
@Table(name = "book")
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
