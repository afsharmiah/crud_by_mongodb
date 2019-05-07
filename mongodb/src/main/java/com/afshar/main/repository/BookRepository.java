package com.afshar.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.afshar.main.model.Book;


public interface BookRepository extends MongoRepository<Book, Integer> {


	
}
