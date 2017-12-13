package javaApp.Repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javaApp.Models.Author;
import javaApp.Models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	List<Book> findAllByreleaseDateGreaterThan(Date date);
	
	@Query("SELECT b FROM Book b JOIN b.author a WHERE a.firstName = :firstName and a.lastName = :lastName ORDER BY b.releaseDate DESC, b.title, b.copies")
	List<Book> FindAllByAutor(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
