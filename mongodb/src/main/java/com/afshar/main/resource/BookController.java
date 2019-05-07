package com.afshar.main.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.afshar.main.model.Book;
import com.afshar.main.repository.BookRepository;

@RestController
public class BookController {
	@Autowired
	private BookRepository repository;

	@PostMapping("/addbook")
	public String saveBook(@RequestBody Book book) {
		repository.save(book);
		return "added book with id: " + book.getId();

	}

	@GetMapping("/findAllBooks")
	public List<Book> getBooks() {
		return repository.findAll();
	}

	@GetMapping("/findAllBooks/{id}")
	public Optional<Book> getBook(@PathVariable int id) {
		return repository.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "Book delete with id :" + id;
	}

	@PutMapping("/findAllBooks/{id}")
	public ResponseEntity<Object> BookUpdate(@RequestBody Book book, @PathVariable int id) {
		Optional<Book> userOptional = repository.findById(id);
		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();

		// user.setId(id);
		repository.save(book);

		return ResponseEntity.noContent().build();
	}

}
