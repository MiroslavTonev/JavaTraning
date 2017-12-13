package javaApp.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name", nullable = true)
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
//	@OneToMany(mappedBy = "author")
//	private Set<Book> books;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

//	public Set<Book> getBooks() {
//		return books;
//	}
//
//	public void setBooks(Book  books) {
//		this.books.add(books);
//	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
}
