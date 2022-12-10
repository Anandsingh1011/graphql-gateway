package com.twc.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book")

public class Book {
	@Id
	private String id;
	private String name;
	private String isbn;

	public Book(String id, String name, String isbn) {
		super();
		this.id = id;
		this.name = name;
		this.isbn = isbn;
	}

	public Book() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}