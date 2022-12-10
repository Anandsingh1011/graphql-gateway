package com.twc.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.twc.mongodb.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {

}