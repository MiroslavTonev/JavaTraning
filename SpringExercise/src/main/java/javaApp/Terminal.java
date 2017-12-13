package javaApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javaApp.Models.AgeRestriction;
import javaApp.Models.Author;
import javaApp.Models.Book;
import javaApp.Models.Category;
import javaApp.Models.EditionType;
import javaApp.Services.AuthorService;
import javaApp.Services.BookService;
import javaApp.Services.CategoryService;


@Component
public class Terminal implements CommandLineRunner{
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService аuthorService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	@Override	
	public void run(String... arg0) throws Exception {
		seedDatabase();
		
		 SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
		 Date releaseDate = formatter.parse("01/01/2000");
		 List<Book> booksAfter2000 = bookService.findAllByreleaseDateGreaterThan(releaseDate);
//		 
//		 booksAfter2000.stream()
//		 	.sorted((a, b) -> a.getReleaseDate().compareTo(b.getReleaseDate()))
//		 	.forEach(b -> System.out.println(String.format("title : %s #############  %s", b.getTitle(), b.getReleaseDate().toString())));	
		 
//		 releaseDate = formatter.parse("01/01/1990");
//		 Set<Author> authorsBooks = аuthorService.findAllByBookreleaseDateLessThan(releaseDate);
//		 
//		 for (Author author : authorsBooks) {
//			System.out.println(String.format("%s %s", author.getFirstName(), author.getLastName()));
//		}
		 
//		 LinkedHashMap<Author, Long> authorsBooks = аuthorService.findAuhtorsByBooksCount();
//		
//		 for (Map.Entry<Author, Long> authors : authorsBooks.entrySet()) {
//			System.out.println(String.format("%s %s books count %d", 
//					authors.getKey().getFirstName(), 
//					authors.getKey().getLastName(), 
//					authors.getValue()));
//		}
//		
//		 for (Author author : authorsBooks) {
//			System.out.println(String.format("%s %s", author.getFirstName(), author.getLastName()));
//		}
		 
//		List<Book> booksByAuthor = new ArrayList<>();
//		
//		booksByAuthor = bookService.FindAllByAutor("George", "Powell");			
//		
//		for (Book book : booksByAuthor) {
//			System.out.println(book);
//		}
		
		 List<Book> books = (List<Book>) bookService.findBooks();
		 List<Book> threeBooks = books.subList(0, 3);

		 threeBooks.get(0).getRelatedBooks().add(threeBooks.get(1));
		 threeBooks.get(1).getRelatedBooks().add(threeBooks.get(0));
		 threeBooks.get(0).getRelatedBooks().add(threeBooks.get(2));
		 threeBooks.get(2).getRelatedBooks().add(threeBooks.get(0));

		 //save related books to the database
		 for (Book book : threeBooks) {
		     bookService.save(book);
		 }

		 for (Book book : threeBooks) {
		     System.out.printf("--%s\n", book.getTitle());
		     for (Book relatedBook : book.getRelatedBooks()) {
		         System.out.println(relatedBook.getTitle());
		     }
		 }

		
		
	}


	private void seedDatabase() throws FileNotFoundException, IOException, ParseException {
		String fileAuthors = "C:\\Users\\mirot\\workspace\\SpringExercise\\src\\authors.txt";
		String fileCategories = "C:\\Users\\mirot\\workspace\\SpringExercise\\src\\categories.txt";
		String fileBooks = "C:\\Users\\mirot\\workspace\\SpringExercise\\src\\books.txt";
		
		Random random = new Random();
		List<Author> authors = new ArrayList<>();
		BufferedReader authorReader = new BufferedReader(new FileReader(fileAuthors));
		String lineAuthor = authorReader.readLine();
		while((lineAuthor = authorReader.readLine()) != null){
			String[] data = lineAuthor.split("\\s+");
			String firstName = data[0];
			String lastName = data[1];
			
			Author author = new Author();
			author.setFirstName(firstName);
			author.setLastName(lastName);
			
			аuthorService.save(author);
			authors.add(author);			
		}
		
		List<Category> categories = new ArrayList<>();
		BufferedReader categoryReader = new BufferedReader(new FileReader(fileCategories));
		String linecategory = categoryReader.readLine();
		while((linecategory = categoryReader.readLine()) != null){
			String data = linecategory;
			Category category = new Category();
			category.setName(data);
			
			categoryService.save(category);
			categories.add(category);
		}
		
		BufferedReader booksReader = new BufferedReader(new FileReader(fileBooks));
		String line = booksReader.readLine();
		while((line = booksReader.readLine()) != null){
		    String[] data = line.split("\\s+");		    		    		    	
		    
		    int authorIndex = random.nextInt(authors.size());
		    Author author = authors.get(authorIndex);
		    
		    EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
		    SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
		    Date releaseDate = formatter.parse(data[1]);
		    int copies = Integer.parseInt(data[2]);
		    BigDecimal price = new BigDecimal(data[3]);
		    AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
		    StringBuilder titleBuilder = new StringBuilder();
		    for (int i = 5; i < data.length; i++) {
		        titleBuilder.append(data[i]).append(" ");
		    }
		    titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
		    String title = titleBuilder.toString();

		    Book book = new Book();
		    book.setAuthor(author);
		    book.setEditionType(editionType);
		    book.setReleaseDate(releaseDate);
		    book.setCopies(copies);
		    book.setPrice(price);
		    book.setAgeRestriction(ageRestriction);
		    book.setTitle(title);
		    //TODO add random categories for current book
		    
		    List<Category> randomCategories = new ArrayList<>();		    
		    int categoryIndex = random.nextInt(categories.size());
		    randomCategories.add(categories.get(categoryIndex));
		    book.setCategory(randomCategories);
		    
		    bookService.save(book);
		}
	}

}
