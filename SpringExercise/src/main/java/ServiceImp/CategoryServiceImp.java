package ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Models.Category;
import Repositories.CategoryRepository;
import Services.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void save(Category category) {
		categoryRepository.save(category);		
	}

}
