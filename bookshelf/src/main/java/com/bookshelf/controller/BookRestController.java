package com.bookshelf.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.dao.model.Book;
import com.bookshelf.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/bookshelf/book/save", method = RequestMethod.POST)
	public void saveBook(@RequestBody Book book) {
		bookService.save(book);

	}

	@RequestMapping(value = "/bookshelf/book/update", method = RequestMethod.PUT)
	public void updateBook(@RequestBody Book book) {
		bookService.update(book);
	}

	@RequestMapping(value = "/bookshelf/book/delete", method = RequestMethod.DELETE)
	public void deleteBook(@PathVariable Long bookId) {
		bookService.delete(bookId);
	}

	@RequestMapping(value = "/bookshelf/book/search", method = RequestMethod.GET)
	public List<Book> searchBook(@PathVariable String bookName) {

		return bookService.findByBookName(bookName);
	}

	@RequestMapping(value = "/bookshelf/book/search/id", method = RequestMethod.GET)
	public Book searchBookById(@PathVariable Long bookId) {
		return bookService.findByBookId(bookId);
	}

	@RequestMapping(value = "/bookshelf/book/search/all", method = RequestMethod.GET)
	public List<Book> searchBook() {

		return bookService.getAll();
	}


}
