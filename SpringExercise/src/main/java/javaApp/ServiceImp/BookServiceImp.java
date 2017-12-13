package javaApp.ServiceImp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaApp.Models.Author;
import javaApp.Models.Book;
import javaApp.Repositories.BookRepository;
import javaApp.Services.BookService;

@Service
public class BookServiceImp implements BookService{
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public void save(Book book) {
		bookRepository.save(book);	
	}

	@Override
	public List<Book> findAllByreleaseDateGreaterThan(Date date) {
		return bookRepository.findAllByreleaseDateGreaterThan(date);
	}

	@Override
	public List<Book> FindAllByAutor(String authorFirstName, String authorLastName) {		
		return bookRepository.FindAllByAutor(authorFirstName, authorLastName);
	}

	@Override
	public List<Book> findBooks() {		
		return bookRepository.findAll();
	}
	
	
}
