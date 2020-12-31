package com.bookshelf.service.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bookshelf.dao.model.Book;

@Service
public interface IBookService {
 
	public Book save(Book book);
	public void update(Book book);
	public void delete(Long bookId);
	public List<Book> getAll();
	public List<Book> findByBookName(String book);
	public Book findByBookId(Long bookId);
	public List<Book> searchBar(String keyword);
	
 
}
