package com.twc.mongodb.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.twc.mongodb.model.Book;
import com.twc.mongodb.model.Publisher;
import com.twc.mongodb.repository.BookRepository;

@Component
public class PublisherResolver implements GraphQLResolver<Publisher> {
	@Autowired
	private BookRepository authorRepository;

	public PublisherResolver(BookRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	public Book getBook(Publisher tutorial) {
		return authorRepository.findById(tutorial.getBook().getId()).orElseThrow(null);
	}
}