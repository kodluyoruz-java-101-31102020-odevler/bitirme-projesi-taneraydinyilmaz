package com.bookshelf.dao.reporsitory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 
import com.bookshelf.dao.model.Authors;

@Repository
public interface AuthorRepository extends CrudRepository<Authors, Long> {
	
	@Query("SELECT a FROM Authors a WHERE a.authorId = :id") 
	public Authors findById(@Param("id") int id);
 

	@Query("Select a FROM Authors a WHERE a.authorName = :authorName ")
	public List<Authors> findByAuthor(@Param("authorName") String authorName);

	@Query("Select a FROM Authors a") 
	public List<Authors> getAllAuthors();


	@Query("SELECT a FROM Authors a WHERE a.authorId=:authorId")
	public Authors findByAuthorId(@Param("authorId") Long authorId);
}
