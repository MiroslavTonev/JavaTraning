package javaApp.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javaApp.Models.Category;
import javaApp.Repositories.CategoryRepository;
import javaApp.Services.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void save(Category category) {
		categoryRepository.save(category);		
	}

}
