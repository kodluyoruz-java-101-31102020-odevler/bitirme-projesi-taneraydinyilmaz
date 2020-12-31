package com.bookshelf.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookshelf.dao.model.Book;
import com.bookshelf.dao.reporsitory.BookRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource({"classpath:application.properties"})
public class BookRepositoryTest {
 
	

	@Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorService authorService;
    
    @Test
    @Order(1)
    public void saveBook() {

        Book book = new Book();
        book.setBookName("repo test");
        book.setAuthors(authorService.findByAuthorId(2L));        
        book.setBookDescription("Test repo");
        book.setPageCount("57");
        book.setPublisher("repo");

        Book resultBook = bookRepository.save(book);

        Assert.assertNotNull(resultBook);

    }
}
