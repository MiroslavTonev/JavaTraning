package ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.Book;
import Repositories.BookRepository;
import Services.BookService;

@Service
public class BookServiceImp implements BookService{
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public void save(Book book) {
		bookRepository.save(book);		
	}

	
}
