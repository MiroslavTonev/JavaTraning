package javaApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javaApp.Models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
