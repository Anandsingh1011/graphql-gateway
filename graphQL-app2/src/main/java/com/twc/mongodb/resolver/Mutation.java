package com.twc.mongodb.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.twc.mongodb.model.Book;
import com.twc.mongodb.model.Publisher;
import com.twc.mongodb.repository.BookRepository;
import com.twc.mongodb.repository.PublisherRepository;

@Component
public class Mutation implements GraphQLMutationResolver {
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;

	@Autowired
	public Mutation(BookRepository authorRepository, PublisherRepository tutorialRepository) {
		this.bookRepository = authorRepository;
		this.publisherRepository = tutorialRepository;
	}

	public Book createBook(String name, String isbn) {
		Book author = new Book();
		author.setName(name);
		author.setIsbn(isbn);

		bookRepository.save(author);

		return author;
	}

	public Publisher createPublisher(String title, String description, String book) {

		Optional<Book> b = bookRepository.findById(book);
		Publisher publisher = new Publisher();
		publisher.setBook(b.get());
		publisher.setTitle(title);
		publisher.setDescription(description);

		publisherRepository.save(publisher);

		return publisher;
	}

	public boolean deleteTutorial(String id) {
		publisherRepository.deleteById(id);
		return true;
	}

	public Publisher updateTutorial(String id, String title, String description) throws Exception {
		Optional<Publisher> optTutorial = publisherRepository.findById(id);

		if (optTutorial.isPresent()) {
			Publisher tutorial = optTutorial.get();

			if (title != null)
				tutorial.setTitle(title);
			if (description != null)
				tutorial.setDescription(description);

			publisherRepository.save(tutorial);
			return tutorial;
		}

		throw new Exception("Not found Tutorial to update!");
	}

}