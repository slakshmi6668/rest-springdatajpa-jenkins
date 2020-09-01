package org.dxc.book.repository;


import java.util.List;
import java.util.Optional;

import org.dxc.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface BookRepository extends JpaRepository<Book, Integer>{
	  

	
	 @Query("SELECT c FROM Book c WHERE c.authorName=:authorName") 
	 List<Book> findByAuthorName(@Param("authorName")String authorName); 
	
	 @Query("SELECT d FROM Book d WHERE d.publisher=:publisher") 
	 List<Book> findByPublisher(@Param("publisher")String publisher);


	 @Query("SELECT e FROM Book e WHERE e.category=:category") 
	 List<Book> findByCategory(@Param("category")String category);

	 

	

	



	
} 
	
	 
	


