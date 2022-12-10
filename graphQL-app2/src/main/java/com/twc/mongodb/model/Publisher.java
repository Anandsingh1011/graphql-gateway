package com.twc.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "publisher")
public class Publisher {
	@Id
	private String id;
	private String title;
	private String description;
	private Book book;

	public Publisher() {
	}

	public Publisher(String id, String title, String description, Book book) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.book = book;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}