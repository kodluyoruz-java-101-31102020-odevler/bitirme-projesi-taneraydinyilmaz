package com.bookshelf.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookshelf.annotation.RuntimeAspect;
import com.bookshelf.dao.model.Book;
import com.bookshelf.dao.reporsitory.BookRepository;
import com.bookshelf.service.interfaces.IBookService;

@Service
public class BookService implements IBookService {

	@Autowired
	private BookRepository bookRepository;
	
	
 
	@Override
	@Transactional
	public Book save(Book book) { 
			return bookRepository.save(book);
	}

 
	@Override
	@Transactional 
	public void update(Book book) { 
		bookRepository.save(book);
	}
 
	@RuntimeAspect(active = true)
	@Override
	public List<Book> getAll() { 
		return bookRepository.getAllBooks();
	}

 
	@Override
	public List<Book> findByBookName(String bookName) { 
		return bookRepository.findByBook(bookName);
	}
	
	
 
	@Override
	@Transactional
	public void delete(Long bookId) { 
		if(bookRepository.findByBookId(bookId)!= null) {
			bookRepository.deleteById(bookId);
		}
	}

 
	@Override
	public Book findByBookId(Long bookId) {
		// TODO Auto-generated method stub
		return bookRepository.findByBookId(bookId);
	}

	@RuntimeAspect(active = true)
	@Override
	public List<Book> searchBar(String keyword) {
		if (keyword != null) {
			return bookRepository.findByBook(keyword);
		}
		return bookRepository.getAllBooks();
	}
 

}
