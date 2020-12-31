package com.bookshelf.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bookshelf.dao.model.Book;
import com.bookshelf.dao.reporsitory.BookRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {

	
	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService;
	
	@Before
	public void setUp() {
		
		Book book = new Book();
		book.setBookId(5L);
		book.setBookName("Test Kitabı :)");
		book.setAuthors(authorService.findByAuthorId(5L));
		book.setBookDescription("tester");
		book.setPageCount("57");
		book.setPublisher("Kodluyoruz");
		Mockito
		.when(bookRepository.save(book))
		.thenReturn(book);
	}
	@Test
	public void queryBook() {
		Book book = bookService.findByBookId(5L);
		Assert.assertNotNull(book); 
	}
}
