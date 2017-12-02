package ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.Author;
import Repositories.AuthorRepository;
import Services.AuthorService;

@Service
public class AuthorServiceImp implements AuthorService{
	@Autowired
	private AuthorRepository authorRepository;
	
	
	@Override
	public void save(Author author) {
		authorRepository.save(author);
		
	}

}
