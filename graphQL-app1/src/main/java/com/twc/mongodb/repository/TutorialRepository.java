package com.twc.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.twc.mongodb.model.Tutorial;

public interface TutorialRepository extends MongoRepository<Tutorial, String> {

}