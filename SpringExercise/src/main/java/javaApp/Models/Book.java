package javaApp.Models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.engine.profile.Fetch;


@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "age_restriction")
	private AgeRestriction ageRestriction;
	@Basic
	private int copies;
	@Column(nullable = true)
	private String description;
	@Column(name = "edition_type")
	private EditionType editionType;
	@Basic
	private BigDecimal price;
	@Column(name = "release_date", nullable = true)
	private Date releaseDate;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "books_categories", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private List<Category> category;
	@Basic	
	private String title;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author")
	private Author author;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "related_books", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "related_id"))
	private Set<Book> relatedBooks;		

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AgeRestriction getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(AgeRestriction ageRestriction) {
		this.ageRestriction = ageRestriction;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EditionType getEditionType() {
		return editionType;
	}

	public void setEditionType(EditionType editionType) {
		this.editionType = editionType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Set<Book> getRelatedBooks() {
		return relatedBooks;
	}

	public void setRelatedBooks(Set<Book> relatedBooks) {
		this.relatedBooks = relatedBooks;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", ageRestriction=" + ageRestriction + ", copies=" + copies + ", description="
				+ description + ", editionType=" + editionType + ", price=" + price + ", releaseDate=" + releaseDate
				+ ", category=" + category + ", title=" + title + ", author=" + author + "]";
	}
	
}
