package javaApp.Repositories;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javaApp.Models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
	@Query("SELECT a FROM Book b Join b.author a WHERE b.releaseDate < (:releasedDateParam)")
	Set<Author> findAllByBookreleaseDateLessThan(@Param("releasedDateParam") Date releasedDateParam);
	
	@Query("SELECT COUNT(*) As count, a FROM Book b LEFT JOIN b.author a GROUP BY b.author ORDER BY COUNT(*)")
	List<Object[]>  findAuhtorsByBooksCount();
}
