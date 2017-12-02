package javaApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import Models.AgeRestriction;
import Models.Author;
import Models.Book;
import Models.Category;
import Models.EditionType;
import Services.AuthorService;
import Services.BookService;
import Services.CategoryService;

@Component
public class Terminal implements CommandLineRunner{
//	@Autowired
//	private BookService bookService;
//	
	@Autowired
	private AuthorService authorService;
	
//	@Autowired
//	private CategoryService categoryService;
	
	public Terminal() {		
	}
	
	@Override	
	public void run(String... arg0) throws Exception {
		Random random = new Random();
		List<Author> authors = new ArrayList<>();
		BufferedReader authorReader = new BufferedReader(new FileReader("authors.txt"));
		String lineAuthor = authorReader.readLine();
		while((lineAuthor = authorReader.readLine()) != null){
			String[] data = lineAuthor.split("\\s+");
			String firstName = data[0];
			String lastName = data[1];
			
			Author author = new Author();
			author.setFirstName(firstName);
			author.setLastName(lastName);
			
			authorService.save(author);
			authors.add(author);			
		}
//		
//		List<Category> categories = new ArrayList<>();
//		BufferedReader categoryReader = new BufferedReader(new FileReader("authors.txt"));
//		String linecategory = categoryReader.readLine();
//		while((linecategory = categoryReader.readLine()) != null){
//			String data = lineAuthor;
//			Category category = new Category();
//			category.setName(data);
//			
//			categoryService.save(category);
//			categories.add(category);
//		}
//		
//		BufferedReader booksReader = new BufferedReader(new FileReader("books.txt"));
//		String line = booksReader.readLine();
//		while((line = booksReader.readLine()) != null){
//		    String[] data = line.split("\\s+");		    		    		    	
//		    
//		    int authorIndex = random.nextInt(authors.size());
//		    Author author = authors.get(authorIndex);
//		    EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
//		    SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
//		    Date releaseDate = formatter.parse(data[1]);
//		    int copies = Integer.parseInt(data[2]);
//		    BigDecimal price = new BigDecimal(data[3]);
//		    AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
//		    StringBuilder titleBuilder = new StringBuilder();
//		    for (int i = 5; i < data.length; i++) {
//		        titleBuilder.append(data[i]).append(" ");
//		    }
//		    titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
//		    String title = titleBuilder.toString();
//
//		    Book book = new Book();
//		    book.setAuthor(author);
//		    book.setEditionType(editionType);
//		    book.setReleaseDate(releaseDate);
//		    book.setCopies(copies);
//		    book.setPrice(price);
//		    book.setAgeRestriction(ageRestriction);
//		    book.setTitle(title);
//		    //TODO add random categories for current book
//		    
//		    List<Category> randomCategories = new ArrayList<>();		    
//		    int categoryIndex = random.nextInt(categories.size());
//		    randomCategories.add(categories.get(categoryIndex));
//		    book.setCategory(randomCategories);
//		    
//		    bookService.save(book);
//		}

		
	}

}
