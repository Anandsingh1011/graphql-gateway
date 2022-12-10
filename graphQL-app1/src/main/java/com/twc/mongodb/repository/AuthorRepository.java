package com.twc.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.twc.mongodb.model.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {

}