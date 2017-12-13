package javaApp.Services;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javaApp.Models.Author;

public interface AuthorService {
	void save(Author author);
	
	Set<Author> findAllByBookreleaseDateLessThan(Date date);
	
	LinkedHashMap<Author, Long> findAuhtorsByBooksCount();		
}	
