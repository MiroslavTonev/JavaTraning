package javaApp.Services;

import java.util.Date;
import java.util.List;

import javaApp.Models.Author;
import javaApp.Models.Book;

public interface BookService {
	void save(Book book);
	
	List<Book> findAllByreleaseDateGreaterThan(Date date);
	
	List<Book> FindAllByAutor(String authorFirstName, String authorLastName);
	
	List<Book> findBooks();
}
