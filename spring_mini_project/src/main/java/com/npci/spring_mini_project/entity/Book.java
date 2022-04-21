package com.npci.spring_mini_project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Book {

	@Id
	@Column(name = "BookId")
	private Integer bookId;
	@Column(name = "Title")
	private String title;
	@Column(name = "AuthorName")
	private String authorName;
	@Column(name = "YearOfPublish")
	private Integer yearOfPublish;

}
