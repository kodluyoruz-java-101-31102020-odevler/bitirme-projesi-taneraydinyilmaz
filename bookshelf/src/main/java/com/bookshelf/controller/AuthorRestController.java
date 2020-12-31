package com.bookshelf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookshelf.dao.model.Authors;
import com.bookshelf.service.AuthorService;

@RestController
public class AuthorRestController {

	

	@Autowired
	AuthorService authorService;

	@RequestMapping(value = "/bookshelf/author/save", method = RequestMethod.POST)
	public void saveAuthor(@RequestBody Authors authors) {
		authorService.save(authors);

	}

	@RequestMapping(value = "/bookshelf/author/update", method = RequestMethod.PUT)
	public void updateAuthor(@RequestBody Authors authors) {
		authorService.update(authors);
	}

	@RequestMapping(value = "/bookshelf/author/delete", method = RequestMethod.DELETE)
	public void deleteAuthor(@PathVariable Long authorId) {
		authorService.delete(authorId);
	}

	@RequestMapping(value = "/bookshelf/author/search", method = RequestMethod.GET)
	public List<Authors> searchAuthor(@PathVariable String authorName) {

		return authorService.findByAuthorName(authorName);
	}

	@RequestMapping(value = "/bookshelf/author/search/id", method = RequestMethod.GET)
	public Authors searchBookById(@PathVariable Long authorId) {
		return authorService.findByAuthorId(authorId);
	}

	@RequestMapping(value = "/bookshelf/author/search/all", method = RequestMethod.GET)
	public List<Authors> searchBook() {

		return authorService.getAll();
	}
}
