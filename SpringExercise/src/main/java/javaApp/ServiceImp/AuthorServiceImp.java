package javaApp.ServiceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaApp.Models.Author;
import javaApp.Repositories.AuthorRepository;
import javaApp.Services.AuthorService;

@Service
public class AuthorServiceImp implements AuthorService{
	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public void save(Author author) {
		authorRepository.save(author);
		
	}

	@Override
	public Set<Author> findAllByBookreleaseDateLessThan(Date date) {
		return authorRepository.findAllByBookreleaseDateLessThan(date);
	}

	@Override
	public LinkedHashMap<Author, Long> findAuhtorsByBooksCount() {
		List<Object[]> queryResult = new ArrayList<>();
		queryResult = authorRepository.findAuhtorsByBooksCount();
		LinkedHashMap<Author, Long> authors = new LinkedHashMap<Author, Long>();
		
		for (Object[] objects : queryResult) {
			authors.put((Author) objects[1], (Long)objects[0]);
		}
		
		
		return authors;
	}
	
	
	

}
