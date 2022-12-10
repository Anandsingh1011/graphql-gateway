package com.twc.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.twc.mongodb.model.Publisher;

public interface PublisherRepository extends MongoRepository<Publisher, String> {

}