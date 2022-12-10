package com.twc.mongodb.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.twc.mongodb.model.Author;
import com.twc.mongodb.model.Tutorial;
import com.twc.mongodb.repository.AuthorRepository;
import com.twc.mongodb.repository.TutorialRepository;

import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Query implements GraphQLQueryResolver {
  private AuthorRepository authorRepository;
  private TutorialRepository tutorialRepository;

  @Autowired
  public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
    this.authorRepository = authorRepository;
    this.tutorialRepository = tutorialRepository;
  }

  public Iterable<Author> findAllAuthors(DataFetchingEnvironment e) {
	log.info("getSelectionSet : "+ e.getSelectionSet());
    return authorRepository.findAll();
  }

  public Iterable<Tutorial> findAllTutorials() {
    return tutorialRepository.findAll();
  }

  public long countAuthors() {
    return authorRepository.count();
  }

  public long countTutorials() {
    return tutorialRepository.count();
  }

}