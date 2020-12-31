package com.bookshelf.dao.reporsitory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookshelf.dao.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

	@Query("SELECT b FROM Book b WHERE b.bookId=:bookId ")
	public Book findByBookId(@Param("bookId") Long bookId);

	@Query("SELECT b FROM Book b")
	public List<Book> getAllBooks();

	@Query("SELECT b FROM Book b WHERE b.bookName=:bookName") 	
	public List<Book> findByBook(@Param("bookName") String bookName);
	
}
