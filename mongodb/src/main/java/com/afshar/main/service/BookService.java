package com.afshar.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afshar.main.model.Book;
import com.afshar.main.repository.BookRepository;

@Service
public class BookService implements BookInterface {
	@Autowired
	private BookRepository repository;
	@Override
	public Book BookUpdate(Book ub) {
		Book b = new Book(ub.getId(), ub.getBookName(), ub.getAuthorName());
		repository.save(b);
		return b;
	}

}
