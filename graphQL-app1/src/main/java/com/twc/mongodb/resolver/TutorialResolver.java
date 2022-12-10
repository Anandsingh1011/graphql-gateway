package com.twc.mongodb.resolver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.twc.mongodb.model.Author;
import com.twc.mongodb.model.Tutorial;
import com.twc.mongodb.repository.AuthorRepository;

@Component
public class TutorialResolver implements GraphQLResolver<Tutorial> {
  @Autowired
  private AuthorRepository authorRepository;

  public TutorialResolver(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public Author getAuthor(Tutorial tutorial) {
    return authorRepository.findById(tutorial.getAuthorId()).orElseThrow(null);
  }
}