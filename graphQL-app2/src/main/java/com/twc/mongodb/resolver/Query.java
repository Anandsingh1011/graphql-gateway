package com.twc.mongodb.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.twc.mongodb.model.Book;
import com.twc.mongodb.model.Publisher;
import com.twc.mongodb.repository.BookRepository;
import com.twc.mongodb.repository.PublisherRepository;

import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Query implements GraphQLQueryResolver {
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;

  @Autowired
  public Query(BookRepository authorRepository, PublisherRepository publisherRepository) {
    this.bookRepository = authorRepository;
    this.publisherRepository = publisherRepository;
  }

  public Iterable<Book> findAllBooks(DataFetchingEnvironment e) {
	log.info("getSelectionSet : "+ e.getSelectionSet());
    return bookRepository.findAll();
  }

  public Iterable<Publisher> findAllPublishers() {
    return publisherRepository.findAll();
  }

  public long countBooks() {
    return bookRepository.count();
  }

  public long countPublishers() {
    return publisherRepository.count();
  }

}